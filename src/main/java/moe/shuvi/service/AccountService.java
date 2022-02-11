package moe.shuvi.service;

import moe.shuvi.dao.AccountDao;
import moe.shuvi.model.Account;
import moe.shuvi.model.User;
import moe.shuvi.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


public interface AccountService {

    Result transferAccount(String inAccount, String toAccount, Double money) throws Exception;

    Result findAll(User user, int pageNow, int pageSize) throws Exception;

    Result recharge(String accounts,Double money)throws Exception;

    Result withdrawal(String accounts,Double money)throws Exception;

    int saveAccount(Account account)throws Exception;

    Result removeAccount(int id)throws Exception;
}
