package moe.shuvi;

import moe.shuvi.dao.UserDao;
import moe.shuvi.model.User;
import moe.shuvi.service.UserService;
import moe.shuvi.utils.Result;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import javax.persistence.Access;
import java.util.List;

@SpringBootTest
public class UserTest {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserService userService;
    @Test
    public void findAll() throws Exception {
//        List<User> all = userDao.findAll();
//        all.forEach(System.out::println);
        User user = new User();
//        user.setLoginCode("12");
        Result byPage = userService.findByPage(user, 1, 3);
        Page<User> data = (Page<User>)byPage.getData();
        data.getContent().forEach(System.out::println);
    }

}
