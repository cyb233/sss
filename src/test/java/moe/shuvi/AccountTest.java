package moe.shuvi;

import moe.shuvi.model.User;
import moe.shuvi.service.AccountService;
import moe.shuvi.utils.Result;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class AccountTest {
    @Autowired
    private AccountService accountService;

    @Test
    public void transferAccount() throws Exception {

        Result result = accountService.transferAccount("12345", "4321", 200.0);
        System.out.println(result.getMsg());
    }
    @Test
    public void findAll()throws Exception{
        User user = new User();
        Result all = accountService.findAll(user, 1, 4);
        Page<User> data = (Page<User>)all.getData();
        List<User> content = data.getContent();
        content.forEach(System.out::println);
//        System.out.println("1____"+content);
    }

}
