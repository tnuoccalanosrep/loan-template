package com.jigu.loan.dao.mapper;


import com.jigu.loan.entity.LoanFollower;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class LoanFollowerSqlProvider {

    public String insertSelective(LoanFollower record) {
        BEGIN();
        INSERT_INTO("loan_follower");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getUserName() != null) {
            VALUES("userName", "#{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getAvatar() != null) {
            VALUES("avatar", "#{avatar,jdbcType=VARCHAR}");
        }
        
        if (record.getMobile() != null) {
            VALUES("mobile", "#{mobile,jdbcType=VARCHAR}");
        }
        
        if (record.getOpenId() != null) {
            VALUES("openId", "#{openId,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            VALUES("createTime", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            VALUES("updateTime", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getVerifyStatus() != null) {
            VALUES("verifyStatus", "#{verifyStatus,jdbcType=TINYINT}");
        }
        
        if (record.getState() != null) {
            VALUES("state", "#{state,jdbcType=TINYINT}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(LoanFollower record) {
        BEGIN();
        UPDATE("loan_follower");
        
        if (record.getUserName() != null) {
            SET("userName = #{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getAvatar() != null) {
            SET("avatar = #{avatar,jdbcType=VARCHAR}");
        }
        
        if (record.getMobile() != null) {
            SET("mobile = #{mobile,jdbcType=VARCHAR}");
        }
        
        if (record.getOpenId() != null) {
            SET("openId = #{openId,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            SET("createTime = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("updateTime = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getVerifyStatus() != null) {
            SET("verifyStatus = #{verifyStatus,jdbcType=TINYINT}");
        }
        
        if (record.getState() != null) {
            SET("state = #{state,jdbcType=TINYINT}");
        }
        
        WHERE("id = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }
}