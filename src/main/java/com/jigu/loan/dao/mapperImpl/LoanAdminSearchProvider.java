package com.jigu.loan.dao.mapperImpl;

import com.jigu.loan.vo.admin.LoanAdminSearchVo;

public class LoanAdminSearchProvider {

    private String createSQL(LoanAdminSearchVo searchVo, boolean isTotal){

        int pageNum = searchVo.getPageNum() > 0 ? searchVo.getPageNum() : 1;
        int pageSize = searchVo.getPageSize() > 0 ? searchVo.getPageSize() : 10;

        String userName = searchVo.getUserName() != null ? searchVo.getUserName().trim() : "";
        String mobile = searchVo.getMobile() != null ? searchVo.getMobile().trim() : "";
        String maxTime = searchVo.getMaxTime();
        String minTime = searchVo.getMinTime();


        String sql = " select " +
                (isTotal ? " count(*)" : " * ") +
                " from loan_admin where 1 = 1 " +
                (userName.length() > 0 ? String.format(" and userName like '%%%s%%' ", userName): "" ) +
                (mobile.length() > 0 ? String.format(" and mobile like '%%%s%%' ", mobile): "" ) +
                (maxTime != null ? String.format(" and createTime <= '%s' ", maxTime): "" ) +
                (minTime != null ? String.format(" and createTime >= '%s'  ", userName): "" ) +
                (isTotal ? "" : String.format(" limit %s, %s ", (pageNum - 1) * pageSize, pageSize));
        return sql;
    }

    public String findPaged(LoanAdminSearchVo searchVo){
        return this.createSQL(searchVo, false);
    }

    public String findTotal(LoanAdminSearchVo searchVo){
        return this.createSQL(searchVo, true);
    }

}
