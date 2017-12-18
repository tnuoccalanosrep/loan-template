package com.jigu.loan.dao.mapper;

import com.jigu.loan.entity.LoanAdmin;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface LoanAdminMapper {
    @Delete({
        "delete from loan_admin",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into loan_admin (id, isRoot, ",
        "userName, remark, ",
        "password, mobile, ",
        "createTime, updateTime, ",
        "status)",
        "values (#{id,jdbcType=INTEGER}, #{isRoot,jdbcType=TINYINT}, ",
        "#{userName,jdbcType=VARCHAR}, #{remark,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{mobile,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{status,jdbcType=TINYINT})"
    })
    int insert(LoanAdmin record);

    @InsertProvider(type=LoanAdminSqlProvider.class, method="insertSelective")
    int insertSelective(LoanAdmin record);

    @Select({
        "select",
        "id, isRoot, userName, remark, password, mobile, createTime, updateTime, status",
        "from loan_admin",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
        @Result(column="isRoot", property="isRoot", jdbcType= JdbcType.TINYINT),
        @Result(column="userName", property="userName", jdbcType= JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType= JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType= JdbcType.VARCHAR),
        @Result(column="mobile", property="mobile", jdbcType= JdbcType.VARCHAR),
        @Result(column="createTime", property="createTime", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="updateTime", property="updateTime", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType= JdbcType.TINYINT)
    })
    LoanAdmin selectByPrimaryKey(Integer id);

    @UpdateProvider(type=LoanAdminSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(LoanAdmin record);

    @Update({
        "update loan_admin",
        "set isRoot = #{isRoot,jdbcType=TINYINT},",
          "userName = #{userName,jdbcType=VARCHAR},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "mobile = #{mobile,jdbcType=VARCHAR},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=TINYINT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(LoanAdmin record);
}