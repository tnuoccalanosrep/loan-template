package com.jigu.loan.dao.mapper;

import com.jigu.loan.entity.LoanDetailInfo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface LoanDetailInfoMapper {
    @Delete({
        "delete from loan_detail_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into loan_detail_info (id, loanInfoId, ",
        "infoName, imgs)",
        "values (#{id,jdbcType=BIGINT}, #{loanInfoId,jdbcType=BIGINT}, ",
        "#{infoName,jdbcType=VARCHAR}, #{imgs,jdbcType=LONGVARCHAR})"
    })
    int insert(LoanDetailInfo record);

    @InsertProvider(type=LoanDetailInfoSqlProvider.class, method="insertSelective")
    int insertSelective(LoanDetailInfo record);

    @Select({
        "select",
        "id, loanInfoId, infoName, imgs",
        "from loan_detail_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.BIGINT, id=true),
        @Result(column="loanInfoId", property="loanInfoId", jdbcType= JdbcType.BIGINT),
        @Result(column="infoName", property="infoName", jdbcType= JdbcType.VARCHAR),
        @Result(column="imgs", property="imgs", jdbcType= JdbcType.LONGVARCHAR)
    })
    LoanDetailInfo selectByPrimaryKey(Long id);

    @UpdateProvider(type=LoanDetailInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(LoanDetailInfo record);

    @Update({
        "update loan_detail_info",
        "set loanInfoId = #{loanInfoId,jdbcType=BIGINT},",
          "infoName = #{infoName,jdbcType=VARCHAR},",
          "imgs = #{imgs,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(LoanDetailInfo record);

    @Update({
        "update loan_detail_info",
        "set loanInfoId = #{loanInfoId,jdbcType=BIGINT},",
          "infoName = #{infoName,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(LoanDetailInfo record);
}