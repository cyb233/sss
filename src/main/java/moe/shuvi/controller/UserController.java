package moe.shuvi.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import moe.shuvi.log.LogAnnotation;
import moe.shuvi.model.User;
import moe.shuvi.service.UserService;
import moe.shuvi.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "UserController",description = "用户登录登出汇总",tags = "UserController")
@RestController
@RequestMapping("/user")
//跨域允许
@CrossOrigin("https://web.shuvi.moe")
public class UserController {

    @Autowired
    private UserService userService;
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true ,dataType = "string"),
            @ApiImplicitParam(name = "passwd", value = "密码", required = true ,dataType = "string")
    })
    @LogAnnotation(title = "用户模块",action = "用户登录")
    @RequestMapping("/login")
    public Result toLogin(@RequestBody User user)throws Exception{
        Result result  = new Result();
        User byLogin = userService.findByLogin(user);
        if (byLogin != null) {
            result.setData(byLogin);
            result.setCode(Result.CODE_SUCCESS);
            result.setMsg(Result.MSG_SUCCESS);
        }else {
            result.setMsg(Result.MSG_ERROR);
            result.setCode(Result.CODE_ERROR);
        }
        return result;
    }
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNow", value = "当前页", required = true ,dataType = "int"),
            @ApiImplicitParam(name = "pageSize", value = "当页容量", required = true ,dataType = "int")
    })
    @LogAnnotation(title = "用户模块",action = "用户查询")
    @RequestMapping("/page")
    public Result findAll(@RequestBody User user,int pageNow,@RequestParam int pageSize) throws Exception{
        Result byPage = userService.findByPage(user, pageNow, pageSize);
        return byPage;
    }
    @LogAnnotation(title = "用户模块",action = "用户注册")
    @RequestMapping("/register")
    public Result register(@RequestBody User user)throws Exception{
        Result result = userService.addUser(user);
        return result;
    }
    @LogAnnotation(title = "用户模块",action = "用户删除")
    @RequestMapping("/remove")
    public Result removeById(@RequestParam int id)throws Exception{
        Result result = userService.removeUserBYId(id);
        return result;
    }
    @LogAnnotation(title = "用户模块",action = "用户修改")
    @RequestMapping("/update")
    public Result modify(@RequestBody User user)throws Exception{
        Result result = userService.addUser(user);
        return result;
    }
}
