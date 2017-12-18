package com.jigu.loan.dao.mapper;

import com.jigu.loan.entity.LoanType;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class LoanTypeSqlProvider {

    public String insertSelective(LoanType record) {
        BEGIN();
        INSERT_INTO("loan_type");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=TINYINT}");
        }
        
        if (record.getName() != null) {
            VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            VALUES("status", "#{status,jdbcType=TINYINT}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(LoanType record) {
        BEGIN();
        UPDATE("loan_type");
        
        if (record.getName() != null) {
            SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            SET("status = #{status,jdbcType=TINYINT}");
        }
        
        WHERE("id = #{id,jdbcType=TINYINT}");
        
        return SQL();
    }
}