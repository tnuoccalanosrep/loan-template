package com.jigu.loan.dao.mapper;

import com.jigu.loan.entity.LoanType;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface LoanTypeMapper {
    @Delete({
        "delete from loan_type",
        "where id = #{id,jdbcType=TINYINT}"
    })
    int deleteByPrimaryKey(Byte id);

    @Insert({
        "insert into loan_type (id, name, ",
        "status)",
        "values (#{id,jdbcType=TINYINT}, #{name,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=TINYINT})"
    })
    int insert(LoanType record);

    @InsertProvider(type=LoanTypeSqlProvider.class, method="insertSelective")
    int insertSelective(LoanType record);

    @Select({
        "select",
        "id, name, status",
        "from loan_type",
        "where id = #{id,jdbcType=TINYINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.TINYINT, id=true),
        @Result(column="name", property="name", jdbcType= JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType= JdbcType.TINYINT)
    })
    LoanType selectByPrimaryKey(Byte id);

    @UpdateProvider(type=LoanTypeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(LoanType record);

    @Update({
        "update loan_type",
        "set name = #{name,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=TINYINT}",
        "where id = #{id,jdbcType=TINYINT}"
    })
    int updateByPrimaryKey(LoanType record);
}