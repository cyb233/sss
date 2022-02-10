package moe.shuvi.service.impl;

import moe.shuvi.dao.AccountDao;
import moe.shuvi.model.Account;
import moe.shuvi.model.User;
import moe.shuvi.service.AccountService;
import moe.shuvi.service.UserService;
import moe.shuvi.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private UserService userService;

    @Transactional
    @Override
    public Result transferAccount(User user, String toAccount, Double money) throws Exception {
        Result result = new Result();
        Account account = new Account();
        account.setUserId(user.getId());
        Example<Account> example = Example.of(account);
        Optional<Account> one = accountDao.findOne(example);
        Account byId = one.get();
        String accountIn = byId.getAccount();
        int In = accountDao.addMoney(toAccount, money);
        int To = accountDao.deleteMoney(accountIn, money);
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
       return null;
    }
}
