package com.jigu.loan.dao.mapper;

import com.jigu.loan.entity.LoanDetailInfo;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class LoanDetailInfoSqlProvider {

    public String insertSelective(LoanDetailInfo record) {
        BEGIN();
        INSERT_INTO("loan_detail_info");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getLoanInfoId() != null) {
            VALUES("loanInfoId", "#{loanInfoId,jdbcType=BIGINT}");
        }
        
        if (record.getInfoName() != null) {
            VALUES("infoName", "#{infoName,jdbcType=VARCHAR}");
        }
        
        if (record.getImgs() != null) {
            VALUES("imgs", "#{imgs,jdbcType=LONGVARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(LoanDetailInfo record) {
        BEGIN();
        UPDATE("loan_detail_info");
        
        if (record.getLoanInfoId() != null) {
            SET("loanInfoId = #{loanInfoId,jdbcType=BIGINT}");
        }
        
        if (record.getInfoName() != null) {
            SET("infoName = #{infoName,jdbcType=VARCHAR}");
        }
        
        if (record.getImgs() != null) {
            SET("imgs = #{imgs,jdbcType=LONGVARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }
}