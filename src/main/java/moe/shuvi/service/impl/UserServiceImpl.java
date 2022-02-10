package moe.shuvi.service.impl;

import moe.shuvi.dao.UserDao;
import moe.shuvi.model.User;
import moe.shuvi.service.UserService;
import moe.shuvi.utils.JpaUtil;
import moe.shuvi.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User findByLogin(User user) throws Exception {
        Example<User> example = Example.of(user);
        Optional<User> one = userDao.findOne(example);
        if (one.isPresent()) {
            return one.get();
        }
        return null;
    }

    @Override
    public User selectByLoginCode(String loginCode) throws Exception {
        User user = new User();
        user.setLoginCode(loginCode);
        Example<User> example = Example.of(user);
        Optional<User> one = userDao.findOne(example);
        if (one.isPresent()) {
            return one.get();
        }
        return null;
    }

    /**
     * 带有多表查询
     * @param user     搜索的参数
     * @param pageNow  分页的当前页
     * @param pageSize 分页的页数
     * @return 返回Result
     * @author 小张
     */
    @Override
    public Result findByPage(User user, int pageNow, int pageSize) {
        Result result = new Result();
        PageRequest p = PageRequest.of(pageNow - 1, pageSize);
        //复杂查询的分装类
        ExampleMatcher matcher = ExampleMatcher.matching()
                // ExampleMatcher.GenericPropertyMatcher::contains  lambda表达式
                //contains()  全部模糊匹配  startsWith()  前部精确后部模糊   endsWith()  后部精确前部模糊
                //propertyPath 参数是指表字段 大写自动转下划线
                .withMatcher("loginCode", ExampleMatcher.GenericPropertyMatchers.contains())
                //.withIgnorePaths()  忽略字段，不管输入什么值都不加入查询条件
                //.withIgnoreNullValues()  忽略空值
                .withIgnoreNullValues();
        Example<User> example = Example.of(user, matcher);
        Page<User> all = userDao.findAll(example, p);
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
     * @param user 添加或修改参数
     * @return 成功与否
     * @throws Exception
     * @author 小张
     */
    @Transactional
    @Override
    public Result addOrUpdateUser(User user) throws Exception {
        Result result = new Result();
        User save = null;
        if (user.getId() != null) {
            Optional<User> originalUser = userDao.findById(user.getId());
//            System.out.println("-----" + originalUser.get());
            User newUser = originalUser.get();
            if (originalUser.isPresent()) {
                JpaUtil.copyNotNullProperties(user, newUser);
            }
//            System.out.println("===>" + newUser);
            save = userDao.saveAndFlush(newUser);
        } else {
            save = userDao.saveAndFlush(user);
        }


//        userDao.save
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
        int i = userDao.deleteByUser(id);
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
