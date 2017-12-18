package com.jigu.loan.controller.client;

import com.jigu.loan.entity.LoanFollower;
import com.jigu.loan.service.client.LoanInfoService;
import com.jigu.loan.service.LoanFollowerService;
import com.jigu.loan.utils.StringUtils;
import com.jigu.loan.vo.client.LoanFollowerSearchVo;
import com.jigu.loan.vo.client.SimpleLoanInfoVo;
import com.samecity.common.http.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("client/loanInfo")
public class LoanInfoRest {

    @Autowired
    private LoanFollowerService followerService;

    @Autowired
    private LoanInfoService loanInfoService;

    @PostMapping("list")
    public JsonResult infoList(@RequestBody LoanFollowerSearchVo searchVo){

        String openId = searchVo.getOpenId();
        if(StringUtils.isEmpty(openId)){
            return JsonResult.createError("无法获取业务员openId");
        }
        LoanFollower follower = followerService.findByOpenId(openId);
        if(follower == null){
            return JsonResult.createError("业务员不存在，请检查参数");
        }
        List<SimpleLoanInfoVo> list = loanInfoService.getInfoList(follower.getId(), searchVo);
        if(list == null || list.size() == 0){
            return JsonResult.createNoContent();
        }
        return JsonResult.createSuccess(list);
    }
}
