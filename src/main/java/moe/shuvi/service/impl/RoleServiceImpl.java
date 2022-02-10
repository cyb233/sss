package moe.shuvi.service.impl;

import moe.shuvi.dao.RoleDao;
import moe.shuvi.model.Role;
import moe.shuvi.model.User;
import moe.shuvi.service.RoleService;
import moe.shuvi.utils.JpaUtil;
import moe.shuvi.utils.JwtTokenUtil;
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

@Transactional(readOnly = true)
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    /**
     * @param role 搜索的参数
     * @return 返回Result
     * @author 小张
     */
    @Override
    public Result findByPage(Role role) throws Exception {
        Result result = new Result();
        //复杂查询的分装类
        ExampleMatcher matcher = ExampleMatcher.matching()
                // ExampleMatcher.GenericPropertyMatcher::contains  lambda表达式
                //contains()  全部模糊匹配  startsWith()  前部精确后部模糊   endsWith()  后部精确前部模糊
                //propertyPath 参数是指表字段 大写自动转下划线
                .withMatcher("roleCode", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("roleName", ExampleMatcher.GenericPropertyMatchers.contains())
                //.withIgnorePaths()  忽略字段，不管输入什么值都不加入查询条件
                //.withIgnoreNullValues()  忽略空值
                .withIgnoreNullValues();
        Example<Role> example = Example.of(role, matcher);
        List<Role> all = roleDao.findAll(example);
        if (all != null) {
            result.setData(all);
            result.setMsg(Result.MSG_SUCCESS);
            result.setCode(Result.CODE_SUCCESS);
        } else {
            result.setMsg(Result.MSG_ERROR);
            result.setCode(Result.CODE_ERROR);
        }
        return result;
    }

    /**
     * 添加和修改公用一个方法,区别是有id则修改,无id则添加
     *
     * @param role 添加或修改参数
     * @return 成功与否
     * @throws Exception
     * @author 小张
     */
    @Transactional
    @Override
    public Result addOrUpdateRole(Role role) throws Exception {
        Result result = new Result();
        Role save = null;
        if (role.getId() != null) {
            Optional<Role> originalRole = roleDao.findById(role.getId());
//            System.out.println("-----" + originalUser.get());
            Role newRole = originalRole.get();
            if (originalRole.isPresent()) {
                JpaUtil.copyNotNullProperties(role, newRole);
            }
//            System.out.println("===>" + newUser);
            save = roleDao.saveAndFlush(newRole);
        } else {

            save = roleDao.saveAndFlush(role);
        }
        if (save != null) {
            result.setData(save);
            result.setCode(Result.CODE_SUCCESS);
            result.setMsg(Result.MSG_SUCCESS);
        } else {
            result.setMsg(Result.MSG_SUCCESS);
            result.setCode(Result.CODE_ERROR);
        }
        return result;
    }

    /**
     * @param id 删除参数,逻辑删除
     * @return 成功与否
     * @throws Exception
     * @author 小张
     */
    @Transactional
    @Override
    public Result removeUserBYId(int id) throws Exception {
        Result result = new Result();
        int i = roleDao.deleteByRole(id);
        if (i > 0) {
            result.setData(i);
            result.setCode(Result.CODE_SUCCESS);
            result.setMsg(Result.MSG_SUCCESS);
        } else {
            result.setCode(Result.CODE_ERROR);
            result.setMsg(Result.MSG_ERROR);
        }
        return result;
    }
}
