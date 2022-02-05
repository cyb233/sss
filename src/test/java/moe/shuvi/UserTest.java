package moe.shuvi;

import moe.shuvi.dao.UserDao;
import moe.shuvi.model.User;
import moe.shuvi.service.UserService;
import moe.shuvi.utils.Result;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.util.Date;

@SpringBootTest
public class UserTest {
    @Autowired
    private UserService userService;

    @Test
    public void findPage() throws Exception {
        User user = new User();
//        user.setLoginCode("22");
        Result byPage = userService.findByPage(user, 1, 10);
        Page<User> data = (Page<User>) byPage.getData();
        System.out.println(data.getContent());
    }
    @Test
    public void deleteUser() throws Exception {
        Result result = userService.removeUserBYId(15);
        System.out.println(result.getCode());
    }

    @Test
    public void addUser() throws Exception {
        User user = new User();
        user.setLoginCode("9999");
        user.setPassword("1234");
        user.setPassword2("1234");
        user.setUsername("jack");
        user.setBirthday(new Date());
        user.setUserType(1);
        user.setUserAddress("123456");
        user.setCountry("1234");
        user.setCardType(1);
        user.setEmail("1234");
        user.setMobile("123");
        user.setPostCode(1);
        user.setIdCard("123");
        user.setReferId(1);
        user.setCardTypeName("12345");
        user.setRoleId(1);
        user.setRoleName("1234");
        user.setIsStart(1);
        user.setReferCode("1234");
        user.setUserTYpeName("1234");
        Result result = userService.addOrUpdateUser(user);
        System.out.println(result.getMsg());
    }
    @Test
    public void updateUser()throws Exception{
        User user = new User();
        user.setId(10);
        user.setLoginCode("jjj");
        Result result = userService.addOrUpdateUser(user);
        System.out.println(result.getData());

    }
}
