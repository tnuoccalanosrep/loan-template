package com.jigu.loan.dao.mapperImpl;

import com.jigu.loan.dao.mapper.LoanAdminMapper;
import com.jigu.loan.entity.LoanAdmin;
import com.jigu.loan.vo.admin.LoanAdminSearchVo;
import com.jigu.loan.vo.admin.SimpleLoanAdminVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface LoanAdminDao extends LoanAdminMapper{


    @Select("select * from loan_admin where userName = #{userName} " +
            " and password = #{password} ")
    LoanAdmin findByUserNameAndPassword(@Param("userName")String userName,
                                        @Param("password")String password);

    @SelectProvider(type = LoanAdminSearchProvider.class, method = "findPaged")
    List<SimpleLoanAdminVo> findPaged(LoanAdminSearchVo searchVo);

    @SelectProvider(type = LoanAdminSearchProvider.class, method = "findTotal")
    int findTotal(LoanAdminSearchVo searchVo);
}
