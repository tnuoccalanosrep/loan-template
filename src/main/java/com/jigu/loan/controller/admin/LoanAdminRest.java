package com.jigu.loan.controller.admin;

import com.jigu.loan.entity.LoanAdmin;
import com.jigu.loan.service.admin.LoanAdminService;
import com.jigu.loan.utils.StringUtils;
import com.jigu.loan.vo.PageResultVo;
import com.jigu.loan.vo.admin.*;
import com.samecity.common.http.JsonResult;
import com.samecity.common.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("admin/user")
public class LoanAdminRest {


    @Autowired
    private LoanAdminService loanAdminService;

    /**
     * 登录
     * @param session
     * @param loginInfoVo
     * @return
     */
    @PostMapping("login")
    public JsonResult login(HttpSession session, @RequestBody LoginInfoVo loginInfoVo){

        if(loginInfoVo.getUserName() == null || loginInfoVo.getPassword() == null){
            return JsonResult.createParamError();
        }
        String password = MD5Util.encryptWithStal(loginInfoVo.getPassword());
        LoanAdmin adminUser = loanAdminService.findUser(loginInfoVo.getUserName().trim(), password);
        if(adminUser != null){
            session.setAttribute("admin_user", adminUser);
            LoginResultVo result = new LoginResultVo();
            result.setUserName(adminUser.getUserName());
            result.setIsRoot(adminUser.getIsRoot());
            return JsonResult.createSuccess(result);
        }
        return JsonResult.createError("登录失败");
    }


    /**
     * 管理员列表
     * @param searchVo
     * @return
     */
    @PostMapping("list")
    public JsonResult listUser(@RequestBody(required = false) LoanAdminSearchVo searchVo){
        if(searchVo == null){
            searchVo = new LoanAdminSearchVo();
        }
        if(searchVo.getPageNum() <= 0){
            searchVo.setPageNum(1);
        }
        int total = loanAdminService.findTotal(searchVo);
        if(total <= 0){
            return JsonResult.createNoContent();
        }
        List<SimpleLoanAdminVo> users = loanAdminService.findPaged(searchVo);
        if(users == null || users.size() == 0){
            return JsonResult.createNoContent();
        }
        return JsonResult.createSuccess(new PageResultVo<List<SimpleLoanAdminVo>>(searchVo.getPageNum(), users.size(), users, total));
    }

    /**
     * 新增/编辑用户
     * @param session
     * @param user
     * @return
     */
    @PostMapping("save")
    public JsonResult saveUser(HttpSession session, @RequestBody LoanAdmin user){
        LoanAdmin admin = (LoanAdmin)session.getAttribute("admin_user");
        if(user.getIsRoot() > 0){
            if(admin.getIsRoot() == 0){
                return JsonResult.createError("没有该权限");
            }
        }
        if(user.getPassword() != null){
            user.setPassword(MD5Util.encryptWithStal(user.getPassword()));
        }
        boolean ret = loanAdminService.saveUser(user);
        return ret ? JsonResult.createSuccess("保存成功")
                : JsonResult.createError("保存失败");
    }

    /**
     * 删除用户
     * @param session
     * @param userId
     * @return
     */
    @GetMapping("delete/{userId}")
    public JsonResult deleteUser(HttpSession session, @PathVariable("userId") int userId){
        LoanAdmin admin = (LoanAdmin) session.getAttribute("admin_user");
        LoanAdmin user = loanAdminService.findUserById(userId);
        if(user == null){
            return JsonResult.createError("该用户不存在");
        }
        if(user.getIsRoot() > 0){
            if(admin.getIsRoot() == 0){
                return JsonResult.createError("没有该权限");
            }
        }
        boolean ret = loanAdminService.deleteAdmin(userId);
        return ret ? JsonResult.createSuccess("删除成功") :
                JsonResult.createError("删除失败");
    }

    /**
     * 更新密码
     * @param updateInfo
     * @return
     */
    @PostMapping("updatePassword")
    public JsonResult updatePassword(@RequestBody UpdateInfoVo updateInfo){

        if(StringUtils.isEmpty(updateInfo.getUserName())
                || StringUtils.isEmpty(updateInfo.getOldPassword())
                || StringUtils.isEmpty(updateInfo.getNewPassword())){
            return JsonResult.createParamError();
        }
        String password = MD5Util.encryptWithStal(updateInfo.getOldPassword());
        LoanAdmin user = loanAdminService.findUser(updateInfo.getUserName(), password);
        if(user != null){
            user.setPassword(MD5Util.encryptWithStal(updateInfo.getNewPassword()));
            return loanAdminService.updateUser(user) ? JsonResult.createSuccess("修改成功")
                    : JsonResult.createError("修改失败");
        }
        else{
            return JsonResult.createError("无法找到该用户，请检查参数");
        }
    }
}