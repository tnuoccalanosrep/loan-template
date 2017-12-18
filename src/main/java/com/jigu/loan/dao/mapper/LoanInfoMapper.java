package com.jigu.loan.dao.mapper;

import com.jigu.loan.entity.LoanInfo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface LoanInfoMapper {
    @Delete({
        "delete from loan_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into loan_info (id, summary, ",
        "loanTypeId, createTime, ",
        "followerId, creditCard, ",
        "drivingLicense, incomeCertificate, ",
        "mobileCertificate, cashFlow, ",
        "propertyCertificate, application, ",
        "carContract, vehicleDisposal, ",
        "indemnityAgreement, drivingPermit, ",
        "evaluate, otherDetailId, ",
        "serviceContract)",
        "values (#{id,jdbcType=BIGINT}, #{summary,jdbcType=VARCHAR}, ",
        "#{loanTypeId,jdbcType=TINYINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{followerId,jdbcType=INTEGER}, #{creditCard,jdbcType=VARCHAR}, ",
        "#{drivingLicense,jdbcType=VARCHAR}, #{incomeCertificate,jdbcType=VARCHAR}, ",
        "#{mobileCertificate,jdbcType=VARCHAR}, #{cashFlow,jdbcType=VARCHAR}, ",
        "#{propertyCertificate,jdbcType=VARCHAR}, #{application,jdbcType=VARCHAR}, ",
        "#{carContract,jdbcType=VARCHAR}, #{vehicleDisposal,jdbcType=VARCHAR}, ",
        "#{indemnityAgreement,jdbcType=VARCHAR}, #{drivingPermit,jdbcType=VARCHAR}, ",
        "#{evaluate,jdbcType=VARCHAR}, #{otherDetailId,jdbcType=BIGINT}, ",
        "#{serviceContract,jdbcType=LONGVARCHAR})"
    })
    int insert(LoanInfo record);

    @InsertProvider(type=LoanInfoSqlProvider.class, method="insertSelective")
    int insertSelective(LoanInfo record);

    @Select({
        "select",
        "id, summary, loanTypeId, createTime, followerId, creditCard, drivingLicense, ",
        "incomeCertificate, mobileCertificate, cashFlow, propertyCertificate, application, ",
        "carContract, vehicleDisposal, indemnityAgreement, drivingPermit, evaluate, otherDetailId, ",
        "serviceContract",
        "from loan_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.BIGINT, id=true),
        @Result(column="summary", property="summary", jdbcType= JdbcType.VARCHAR),
        @Result(column="loanTypeId", property="loanTypeId", jdbcType= JdbcType.TINYINT),
        @Result(column="createTime", property="createTime", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="followerId", property="followerId", jdbcType= JdbcType.INTEGER),
        @Result(column="creditCard", property="creditCard", jdbcType= JdbcType.VARCHAR),
        @Result(column="drivingLicense", property="drivingLicense", jdbcType= JdbcType.VARCHAR),
        @Result(column="incomeCertificate", property="incomeCertificate", jdbcType= JdbcType.VARCHAR),
        @Result(column="mobileCertificate", property="mobileCertificate", jdbcType= JdbcType.VARCHAR),
        @Result(column="cashFlow", property="cashFlow", jdbcType= JdbcType.VARCHAR),
        @Result(column="propertyCertificate", property="propertyCertificate", jdbcType= JdbcType.VARCHAR),
        @Result(column="application", property="application", jdbcType= JdbcType.VARCHAR),
        @Result(column="carContract", property="carContract", jdbcType= JdbcType.VARCHAR),
        @Result(column="vehicleDisposal", property="vehicleDisposal", jdbcType= JdbcType.VARCHAR),
        @Result(column="indemnityAgreement", property="indemnityAgreement", jdbcType= JdbcType.VARCHAR),
        @Result(column="drivingPermit", property="drivingPermit", jdbcType= JdbcType.VARCHAR),
        @Result(column="evaluate", property="evaluate", jdbcType= JdbcType.VARCHAR),
        @Result(column="otherDetailId", property="otherDetailId", jdbcType= JdbcType.BIGINT),
        @Result(column="serviceContract", property="serviceContract", jdbcType= JdbcType.LONGVARCHAR)
    })
    LoanInfo selectByPrimaryKey(Long id);

    @UpdateProvider(type=LoanInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(LoanInfo record);

    @Update({
        "update loan_info",
        "set summary = #{summary,jdbcType=VARCHAR},",
          "loanTypeId = #{loanTypeId,jdbcType=TINYINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "followerId = #{followerId,jdbcType=INTEGER},",
          "creditCard = #{creditCard,jdbcType=VARCHAR},",
          "drivingLicense = #{drivingLicense,jdbcType=VARCHAR},",
          "incomeCertificate = #{incomeCertificate,jdbcType=VARCHAR},",
          "mobileCertificate = #{mobileCertificate,jdbcType=VARCHAR},",
          "cashFlow = #{cashFlow,jdbcType=VARCHAR},",
          "propertyCertificate = #{propertyCertificate,jdbcType=VARCHAR},",
          "application = #{application,jdbcType=VARCHAR},",
          "carContract = #{carContract,jdbcType=VARCHAR},",
          "vehicleDisposal = #{vehicleDisposal,jdbcType=VARCHAR},",
          "indemnityAgreement = #{indemnityAgreement,jdbcType=VARCHAR},",
          "drivingPermit = #{drivingPermit,jdbcType=VARCHAR},",
          "evaluate = #{evaluate,jdbcType=VARCHAR},",
          "otherDetailId = #{otherDetailId,jdbcType=BIGINT},",
          "serviceContract = #{serviceContract,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(LoanInfo record);

    @Update({
        "update loan_info",
        "set summary = #{summary,jdbcType=VARCHAR},",
          "loanTypeId = #{loanTypeId,jdbcType=TINYINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "followerId = #{followerId,jdbcType=INTEGER},",
          "creditCard = #{creditCard,jdbcType=VARCHAR},",
          "drivingLicense = #{drivingLicense,jdbcType=VARCHAR},",
          "incomeCertificate = #{incomeCertificate,jdbcType=VARCHAR},",
          "mobileCertificate = #{mobileCertificate,jdbcType=VARCHAR},",
          "cashFlow = #{cashFlow,jdbcType=VARCHAR},",
          "propertyCertificate = #{propertyCertificate,jdbcType=VARCHAR},",
          "application = #{application,jdbcType=VARCHAR},",
          "carContract = #{carContract,jdbcType=VARCHAR},",
          "vehicleDisposal = #{vehicleDisposal,jdbcType=VARCHAR},",
          "indemnityAgreement = #{indemnityAgreement,jdbcType=VARCHAR},",
          "drivingPermit = #{drivingPermit,jdbcType=VARCHAR},",
          "evaluate = #{evaluate,jdbcType=VARCHAR},",
          "otherDetailId = #{otherDetailId,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(LoanInfo record);
}