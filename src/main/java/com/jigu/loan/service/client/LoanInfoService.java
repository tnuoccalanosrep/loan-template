package com.jigu.loan.service.client;

import com.jigu.loan.dao.mapperImpl.LoanInfoDao;
import com.jigu.loan.vo.client.LoanFollowerSearchVo;
import com.jigu.loan.vo.client.SimpleLoanInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanInfoService {

    @Autowired
    private LoanInfoDao loanInfoDao;

    public List<SimpleLoanInfoVo> getInfoList(long userId, LoanFollowerSearchVo searchVo){

        if(searchVo.getPageNum() <= 0){
            searchVo.setPageNum(1);
        }
        if(searchVo.getPageSize() <= 0){
            searchVo.setPageSize(10);
        }
        int index = (searchVo.getPageNum() - 1) * searchVo.getPageSize();
        int size= searchVo.getPageSize();
        return loanInfoDao.findPaged(userId, index, size);
    }

}
