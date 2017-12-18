package com.jigu.loan.dao.mapper;

import com.jigu.loan.entity.LoanFollower;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface LoanFollowerMapper {
    @Delete({
        "delete from loan_follower",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into loan_follower (id, userName, ",
        "avatar, mobile, ",
        "openId, createTime, ",
        "updateTime, verifyStatus, ",
        "state)",
        "values (#{id,jdbcType=BIGINT}, #{userName,jdbcType=VARCHAR}, ",
        "#{avatar,jdbcType=VARCHAR}, #{mobile,jdbcType=VARCHAR}, ",
        "#{openId,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{verifyStatus,jdbcType=TINYINT}, ",
        "#{state,jdbcType=TINYINT})"
    })
    int insert(LoanFollower record);

    @InsertProvider(type=LoanFollowerSqlProvider.class, method="insertSelective")
    int insertSelective(LoanFollower record);

    @Select({
        "select",
        "id, userName, avatar, mobile, openId, createTime, updateTime, verifyStatus, ",
        "state",
        "from loan_follower",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.BIGINT, id=true),
        @Result(column="userName", property="userName", jdbcType= JdbcType.VARCHAR),
        @Result(column="avatar", property="avatar", jdbcType= JdbcType.VARCHAR),
        @Result(column="mobile", property="mobile", jdbcType= JdbcType.VARCHAR),
        @Result(column="openId", property="openId", jdbcType= JdbcType.VARCHAR),
        @Result(column="createTime", property="createTime", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="updateTime", property="updateTime", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="verifyStatus", property="verifyStatus", jdbcType= JdbcType.TINYINT),
        @Result(column="state", property="state", jdbcType= JdbcType.TINYINT)
    })
    LoanFollower selectByPrimaryKey(Long id);

    @UpdateProvider(type=LoanFollowerSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(LoanFollower record);

    @Update({
        "update loan_follower",
        "set userName = #{userName,jdbcType=VARCHAR},",
          "avatar = #{avatar,jdbcType=VARCHAR},",
          "mobile = #{mobile,jdbcType=VARCHAR},",
          "openId = #{openId,jdbcType=VARCHAR},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "verifyStatus = #{verifyStatus,jdbcType=TINYINT},",
          "state = #{state,jdbcType=TINYINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(LoanFollower record);
}