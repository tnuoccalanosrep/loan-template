package com.jigu.loan.vo.admin;

import com.jigu.loan.vo.PageVo;
import lombok.Data;

@Data
public class LoanAdminSearchVo extends PageVo{

    /*
    用户名称
     */
    private String userName;

    /*
    手机号
     */
    private String mobile;

    /*
    最大时间
     */
    private String maxTime;

    /*
    最小时间
     */
    private String minTime;
}
