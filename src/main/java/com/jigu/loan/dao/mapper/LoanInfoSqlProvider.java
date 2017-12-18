package com.jigu.loan.dao.mapper;

import com.jigu.loan.entity.LoanInfo;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class LoanInfoSqlProvider {

    public String insertSelective(LoanInfo record) {
        BEGIN();
        INSERT_INTO("loan_info");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getSummary() != null) {
            VALUES("summary", "#{summary,jdbcType=VARCHAR}");
        }
        
        if (record.getLoanTypeId() != null) {
            VALUES("loanTypeId", "#{loanTypeId,jdbcType=TINYINT}");
        }
        
        if (record.getCreateTime() != null) {
            VALUES("createTime", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getFollowerId() != null) {
            VALUES("followerId", "#{followerId,jdbcType=INTEGER}");
        }
        
        if (record.getCreditCard() != null) {
            VALUES("creditCard", "#{creditCard,jdbcType=VARCHAR}");
        }
        
        if (record.getDrivingLicense() != null) {
            VALUES("drivingLicense", "#{drivingLicense,jdbcType=VARCHAR}");
        }
        
        if (record.getIncomeCertificate() != null) {
            VALUES("incomeCertificate", "#{incomeCertificate,jdbcType=VARCHAR}");
        }
        
        if (record.getMobileCertificate() != null) {
            VALUES("mobileCertificate", "#{mobileCertificate,jdbcType=VARCHAR}");
        }
        
        if (record.getCashFlow() != null) {
            VALUES("cashFlow", "#{cashFlow,jdbcType=VARCHAR}");
        }
        
        if (record.getPropertyCertificate() != null) {
            VALUES("propertyCertificate", "#{propertyCertificate,jdbcType=VARCHAR}");
        }
        
        if (record.getApplication() != null) {
            VALUES("application", "#{application,jdbcType=VARCHAR}");
        }
        
        if (record.getCarContract() != null) {
            VALUES("carContract", "#{carContract,jdbcType=VARCHAR}");
        }
        
        if (record.getVehicleDisposal() != null) {
            VALUES("vehicleDisposal", "#{vehicleDisposal,jdbcType=VARCHAR}");
        }
        
        if (record.getIndemnityAgreement() != null) {
            VALUES("indemnityAgreement", "#{indemnityAgreement,jdbcType=VARCHAR}");
        }
        
        if (record.getDrivingPermit() != null) {
            VALUES("drivingPermit", "#{drivingPermit,jdbcType=VARCHAR}");
        }
        
        if (record.getEvaluate() != null) {
            VALUES("evaluate", "#{evaluate,jdbcType=VARCHAR}");
        }
        
        if (record.getOtherDetailId() != null) {
            VALUES("otherDetailId", "#{otherDetailId,jdbcType=BIGINT}");
        }
        
        if (record.getServiceContract() != null) {
            VALUES("serviceContract", "#{serviceContract,jdbcType=LONGVARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(LoanInfo record) {
        BEGIN();
        UPDATE("loan_info");
        
        if (record.getSummary() != null) {
            SET("summary = #{summary,jdbcType=VARCHAR}");
        }
        
        if (record.getLoanTypeId() != null) {
            SET("loanTypeId = #{loanTypeId,jdbcType=TINYINT}");
        }
        
        if (record.getCreateTime() != null) {
            SET("createTime = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getFollowerId() != null) {
            SET("followerId = #{followerId,jdbcType=INTEGER}");
        }
        
        if (record.getCreditCard() != null) {
            SET("creditCard = #{creditCard,jdbcType=VARCHAR}");
        }
        
        if (record.getDrivingLicense() != null) {
            SET("drivingLicense = #{drivingLicense,jdbcType=VARCHAR}");
        }
        
        if (record.getIncomeCertificate() != null) {
            SET("incomeCertificate = #{incomeCertificate,jdbcType=VARCHAR}");
        }
        
        if (record.getMobileCertificate() != null) {
            SET("mobileCertificate = #{mobileCertificate,jdbcType=VARCHAR}");
        }
        
        if (record.getCashFlow() != null) {
            SET("cashFlow = #{cashFlow,jdbcType=VARCHAR}");
        }
        
        if (record.getPropertyCertificate() != null) {
            SET("propertyCertificate = #{propertyCertificate,jdbcType=VARCHAR}");
        }
        
        if (record.getApplication() != null) {
            SET("application = #{application,jdbcType=VARCHAR}");
        }
        
        if (record.getCarContract() != null) {
            SET("carContract = #{carContract,jdbcType=VARCHAR}");
        }
        
        if (record.getVehicleDisposal() != null) {
            SET("vehicleDisposal = #{vehicleDisposal,jdbcType=VARCHAR}");
        }
        
        if (record.getIndemnityAgreement() != null) {
            SET("indemnityAgreement = #{indemnityAgreement,jdbcType=VARCHAR}");
        }
        
        if (record.getDrivingPermit() != null) {
            SET("drivingPermit = #{drivingPermit,jdbcType=VARCHAR}");
        }
        
        if (record.getEvaluate() != null) {
            SET("evaluate = #{evaluate,jdbcType=VARCHAR}");
        }
        
        if (record.getOtherDetailId() != null) {
            SET("otherDetailId = #{otherDetailId,jdbcType=BIGINT}");
        }
        
        if (record.getServiceContract() != null) {
            SET("serviceContract = #{serviceContract,jdbcType=LONGVARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }
}