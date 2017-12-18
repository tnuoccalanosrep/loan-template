package com.jigu.loan.vo.client;

import com.jigu.loan.entity.LoanFollower;
import lombok.Data;

@Data
public class LoanFollowerInfoVo extends LoanFollower {
    private String rawData;

    private String signature;

    private String sessionKey;
}
