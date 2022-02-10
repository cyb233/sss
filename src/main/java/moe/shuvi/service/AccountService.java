package moe.shuvi.service;

import moe.shuvi.dao.AccountDao;
import moe.shuvi.model.User;
import moe.shuvi.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


public interface AccountService {

    Result transferAccount(User user, String toAccount, Double money) throws Exception;

    Result findAll(User user, int pageNow, int pageSize) throws Exception;
}
