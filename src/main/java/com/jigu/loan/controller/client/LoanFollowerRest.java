package com.jigu.loan.controller.client;

import com.alibaba.fastjson.JSONObject;
import com.jigu.loan.entity.LoanFollower;
import com.jigu.loan.service.LoanFollowerService;
import com.jigu.loan.utils.StringUtils;
import com.jigu.loan.utils.WechatUtils;
import com.jigu.loan.vo.client.LoanFollowerInfoVo;
import com.samecity.common.http.JsonResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.util.HashMap;


@RestController
@RequestMapping("client/follower")
public class LoanFollowerRest {
    @Value("${wechat.appId}")
    String appId;

    @Value("${wechat.appSecret}")
    String secret;

    @Autowired
    private LoanFollowerService loanFollowerService;

    @GetMapping("checkFollower/{jsCode}")
    public JsonResult checkUser(HttpSession session, @PathVariable("jsCode") String jsCode){

        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appId + "&secret=" + secret + "&js_code=" + jsCode + "&grant_type=authorization_code";
        String result = new RestTemplate().getForObject(url, String.class);

        if (result.contains("openid")){
            JSONObject weiXinJson = (JSONObject) JSONObject.parse(result);
            String openId = weiXinJson.getString("openid");
            String sessionKey = weiXinJson.getString("session_key");
            if(!StringUtils.isEmpty(openId)) {
                LoanFollower follower = loanFollowerService.findByOpenId(openId);
                HashMap<String, String> map = new HashMap<>();
                map.put("openId",openId);
                map.put("sessionKey", sessionKey);
                if (follower == null) {
                    map.put("verifyStatus", "0");//0 表示 还没有提交审核
                }
                else {
                    if (follower.getVerifyStatus() == 2) {
                        //审核通过可以进行后续操作，因此保留session
                        session.setAttribute("client_follower", follower);
                        map.put("userName", follower.getUserName());
                        map.put("mobile", follower.getMobile());
                        map.put("avatar", follower.getAvatar());
                    }
                    map.put("verifyStatus", follower.getVerifyStatus().toString());
                }
                return JsonResult.createSuccess(map);
            }
        }
        return JsonResult.createError("获取openId失败，请检查是否已经授权");
    }

    @PostMapping("uploadFollowerInfo")
    public JsonResult saveUser(@RequestBody LoanFollowerInfoVo followerInfoVo){

        String rawData = followerInfoVo.getRawData();
        String signature = followerInfoVo.getSignature();
        String sessionKey = followerInfoVo.getSessionKey();
        if(WechatUtils.verifyRawData(rawData, sessionKey, signature)){
            LoanFollower follower = loanFollowerService.findByOpenId(followerInfoVo.getOpenId());
            if(follower != null){
                return JsonResult.createError("该用户已经存在了");
            }
            follower = new LoanFollower();
            BeanUtils.copyProperties(followerInfoVo, follower);
            JSONObject weiXinJson = (JSONObject) JSONObject.parse(rawData);
            String avatar = weiXinJson.getString("avatarUrl");
            follower.setVerifyStatus((byte)1);
            follower.setAvatar(avatar);
            boolean ret = loanFollowerService.savFollower(follower);
            return ret ? JsonResult.createSuccess(follower) :
                    JsonResult.createError("提交用户信息失败");
        }
        return JsonResult.createError("微信用户信息有误，请检查参数");

    }
}
