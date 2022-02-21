package moe.shuvi.controller;

import io.swagger.annotations.Api;
import moe.shuvi.log.LogAnnotation;
import moe.shuvi.model.User;
import moe.shuvi.service.AccountService;
import moe.shuvi.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "AccountController", description = "账户接口汇总", tags = "AccountController")
@RestController
@RequestMapping("/account")
@CrossOrigin(origins = {"http://localhost:9528/","https://web.shuvi.moe"}, allowCredentials = "true")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @LogAnnotation(title = "账户模块", action = "账户查看")
    @RequestMapping("/page")
    public Result findAll(@RequestBody User user) throws Exception {
        return accountService.findAll(user, user.getPageNow(), user.getPageSize());
    }

    @LogAnnotation(title = "账户模块", action = "账户转账")
    @RequestMapping("/transfer")
    public Result transfer(@RequestParam String inAccount, @RequestParam String toAccount, @RequestParam Double money) throws Exception {
        return accountService.transferAccount(inAccount, toAccount, money);
    }

    @LogAnnotation(title = "账户模块", action = "账户充值")
    @RequestMapping("/recharge")
    public Result recharge(@RequestParam String accounts, @RequestParam Double money) throws Exception {
        return accountService.recharge(accounts, money);
    }

    @LogAnnotation(title = "账户模块", action = "账户体现")
    @RequestMapping("/withdrawal")
    public Result withdrawal(@RequestParam String accounts, @RequestParam Double money) throws Exception {
        return accountService.withdrawal(accounts, money);
    }

    @LogAnnotation(title = "账户模块", action = "账户删除")
    @RequestMapping("/delete")
    public Result deleteAccount(@RequestParam int id) throws Exception {
        return accountService.removeAccount(id);
    }
}
