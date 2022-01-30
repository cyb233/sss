package moe.shuvi.controller;

import moe.shuvi.model.User;
import moe.shuvi.service.OrderService;
import moe.shuvi.service.UserService;
import moe.shuvi.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author schwi
 * @date 2022/01/30 21:06
 */

@RestController
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public Result login(User user) throws Exception {
        Result result = new Result();
        User u = userService.findByLogin(user);
        if (u != null) {
            result.setCode(Result.CODE_SUCCESS);
            result.setData(u);
        } else {
            result.setCode(Result.CODE_LOGIN_FAILED);
            result.setMsg(Result.MSG_LOGIN_FAILED);
        }
        return result;
    }
}
