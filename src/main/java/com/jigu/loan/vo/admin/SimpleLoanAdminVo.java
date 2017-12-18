package com.jigu.loan.vo.admin;

import lombok.Data;

import java.util.Date;

@Data
public class SimpleLoanAdminVo {

    private String userName;

    private String mobile;

    private String remark;

    private Date createTime;

    private Byte status;

    private Byte isRoot;
}
