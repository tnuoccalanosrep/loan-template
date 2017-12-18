package com.jigu.loan.service.admin;

import com.jigu.loan.dao.mapperImpl.LoanAdminDao;
import com.jigu.loan.entity.LoanAdmin;
import com.jigu.loan.utils.StringUtils;
import com.jigu.loan.vo.admin.LoanAdminSearchVo;
import com.jigu.loan.vo.admin.SimpleLoanAdminVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanAdminService {

    @Autowired
    private LoanAdminDao loanAdminDao;


    public LoanAdmin findUser(String userName, String password) {
        return loanAdminDao.findByUserNameAndPassword(userName, password);
    }


    public boolean saveUser(LoanAdmin adminUserVo) {
        if(adminUserVo.getId() == null){
            if(StringUtils.isEmpty(adminUserVo.getUserName())
                    || StringUtils.isEmpty(adminUserVo.getPassword())){
                return false;
            }
            return loanAdminDao.insertSelective(adminUserVo) > 0;
        }
        else{
            return loanAdminDao.updateByPrimaryKeySelective(adminUserVo) > 0;
        }
    }

    public Boolean updateUser(LoanAdmin user) {
        return loanAdminDao.updateByPrimaryKeySelective(user) > 0;
    }


    public List<SimpleLoanAdminVo> findPaged(LoanAdminSearchVo searchVo) {

        return loanAdminDao.findPaged(searchVo);
    }

    public int findTotal(LoanAdminSearchVo searchVo){
        return loanAdminDao.findTotal(searchVo);
    }


    public LoanAdmin findUserById(int userId) {
        return loanAdminDao.selectByPrimaryKey(userId);
    }


    public boolean deleteAdmin(int userId) {
        return loanAdminDao.deleteByPrimaryKey(userId) > 0;
    }
}
