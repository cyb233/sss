package moe.shuvi;

import moe.shuvi.model.User;
import moe.shuvi.service.AccountService;
import moe.shuvi.utils.Result;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class AccountTest {
    @Autowired
    private AccountService accountService;

    @Test
    public void transferAccount() throws Exception {
        User user = new User();
        user.setId(10);
        Result result = accountService.transferAccount(user, "4321", 200.0);
        System.out.println(result.getMsg());
    }
}
