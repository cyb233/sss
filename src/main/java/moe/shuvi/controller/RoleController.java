package moe.shuvi.controller;

import io.swagger.annotations.Api;
import moe.shuvi.log.LogAnnotation;
import moe.shuvi.model.Role;
import moe.shuvi.service.RoleService;
import moe.shuvi.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "RoleController",description = "角色接口汇总",tags = "RoleController")
@RequestMapping("/role")
@RestController
@CrossOrigin(origins = {"http://localhost:9528/","https://web.shuvi.moe"}, allowCredentials = "true")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @LogAnnotation(title = "角色模块",action = "角色查询")
    @RequestMapping("/list")
    public Result findRole(@RequestBody Role role)throws Exception{
        Result byPage = roleService.findByPage(role);
        return byPage;
    }
    @LogAnnotation(title = "角色模块",action = "角色添加")
    @RequestMapping("/add")
    public Result addRole(@RequestBody Role role)throws Exception{
        Result result = roleService.addOrUpdateRole(role);
        return result;
    }
    @LogAnnotation(title = "角色模块",action = "角色修改")
    @RequestMapping("/update")
    public Result updateRole(@RequestBody Role role)throws Exception{
        Result result = roleService.addOrUpdateRole(role);
        return result;
    }
    @LogAnnotation(title = "角色模块",action = "角色删除")
    @RequestMapping("/remove")
    public Result removeRole(@RequestParam int id)throws Exception{
        Result result = roleService.removeUserBYId(id);
        return result;
    }
}
