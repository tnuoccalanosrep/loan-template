package com.jigu.loan.dao.mapperImpl;

import com.jigu.loan.dao.mapper.LoanInfoMapper;
import com.jigu.loan.vo.client.SimpleLoanInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LoanInfoDao extends LoanInfoMapper {


    @Select(" select li.summary as title, " +
            " li.createTime, lt.name as loanType " +
            " from loan_info li " +
            " inner join loan_type lt " +
            " on lt.id = li.loanTypeId " +
            " where li.followerId = #{followerId} " +
            " order by createTime desc " +
            " limit #{index}, #{size}")
    List<SimpleLoanInfoVo> findPaged(@Param("followerId")long followerId,
                                     @Param("index")int index,
                                     @Param("size")int size);
}
