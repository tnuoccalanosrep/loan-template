package com.jigu.loan.service;


import com.jigu.loan.dao.mapperImpl.LoanFollowerDao;
import com.jigu.loan.entity.LoanFollower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanFollowerService {

    @Autowired
    private LoanFollowerDao loanFollowerDao;


    public LoanFollower findByOpenId(String openId) {

        return loanFollowerDao.findByOpenId(openId);
    }

    public boolean savFollower(LoanFollower userVo) {
        return loanFollowerDao.insertSelective(userVo) > 0;
    }
}
