package com.jigu.loan.dao.mapperImpl;

import com.jigu.loan.dao.mapper.LoanFollowerMapper;
import com.jigu.loan.entity.LoanFollower;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoanFollowerDao extends LoanFollowerMapper {


    @Select(" select * from loan_follower " +
            " where openId = #{openId} ")
    LoanFollower findByOpenId(String openId);
}
