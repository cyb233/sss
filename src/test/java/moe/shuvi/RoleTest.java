package moe.shuvi;

import moe.shuvi.dao.RoleDao;
import moe.shuvi.model.Role;
import moe.shuvi.service.RoleService;
import moe.shuvi.utils.Result;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RoleTest {
    @Autowired
    private RoleService roleService;

    @Test
    public void findRole() throws Exception {
        Role role = new Role();
//        role.setRoleCode("1234");
        Result byPage = roleService.findByPage(role);
        System.out.println(byPage.getData());
    }

//    @Test
    public void addRole() throws Exception {
        Role role = new Role();
//        role.setId(1);
        role.setRoleName("431");
        role.setRoleCode("1234");
        role.setCreateBy("1234");
        role.setIsStart(1);
        Result result = roleService.addOrUpdateRole(role);
        System.out.println(result.getData());
    }
//    @Test
    public void update()throws Exception{
        Role role = new Role();
        role.setId(3);
        role.setRoleName("ggg");
        Result result = roleService.addOrUpdateRole(role);
        System.out.println(result.getData());
    }
//    @Test
    public void remove()throws Exception{
        Result result = roleService.removeUserBYId(3);
        System.out.println(result.getData());
    }
}
