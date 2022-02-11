package moe.shuvi.service.impl;

import io.swagger.annotations.Api;
import moe.shuvi.dao.AccountDao;
import moe.shuvi.dao.UserDao;
import moe.shuvi.model.Account;
import moe.shuvi.model.User;
import moe.shuvi.service.AccountService;
import moe.shuvi.service.UserService;
import moe.shuvi.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional(readOnly = true)
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    //    @Autowired
//    private UserDao userDao;
    @Autowired
    @Lazy
    private UserService userService;

    @Transactional
    @Override
    public Result transferAccount(String inAccount, String toAccount, Double money) throws Exception {
        Result result = new Result();
        int In = accountDao.addMoney(toAccount, money);
        int To = accountDao.deleteMoney(inAccount, money);
        if (In + To == 2) {
            result.setCode(Result.CODE_SUCCESS);
            result.setMsg(Result.MSG_SUCCESS);
        } else {
            result.setMsg(Result.MSG_ERROR);
            result.setCode(Result.CODE_ERROR);
        }
        return result;
    }

    @Override
    public Result findAll(User user, int pageNow, int pageSize) throws Exception {
        return userService.findByPage(user, pageNow, pageSize);
    }

    @Transactional
    @Override
    public Result recharge(String accounts, Double money) throws Exception {
        Result result = new Result();
        int i = accountDao.addMoney(accounts, money);
        if (i == 1) {
            result.setCode(Result.CODE_SUCCESS);
            result.setMsg(Result.MSG_SUCCESS);
        } else {
            result.setMsg(Result.MSG_ERROR);
            result.setCode(Result.CODE_ERROR);
        }
        return result;
    }

    @Transactional
    @Override
    public Result withdrawal(String accounts, Double money) throws Exception {
        Result result = new Result();
        int i = accountDao.deleteMoney(accounts, money);
        if (i == 1) {
            result.setCode(Result.CODE_SUCCESS);
            result.setMsg(Result.MSG_SUCCESS);
        } else {
            result.setMsg(Result.MSG_ERROR);
            result.setCode(Result.CODE_ERROR);
        }
        return result;
    }

    @Transactional
    @Override
    public int saveAccount(Account account) throws Exception {
        Account save = accountDao.saveAndFlush(account);
        if (save.getId() != null) {
            return 1;
        }
        return 0;
    }

    @Transactional
    @Override
    public Result removeAccount(int id) throws Exception {
        Result result = new Result();
        int i = accountDao.deleteByAccount(id);
        if (i == 1) {
            result.setCode(Result.CODE_SUCCESS);
            result.setMsg(Result.MSG_SUCCESS);
        } else {
            result.setMsg(Result.MSG_ERROR);
            result.setCode(Result.CODE_ERROR);
        }
        return result;
    }

}
