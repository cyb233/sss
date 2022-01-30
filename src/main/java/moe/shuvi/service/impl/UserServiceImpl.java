package moe.shuvi.service.impl;

import moe.shuvi.dao.UserDao;
import moe.shuvi.model.User;
import moe.shuvi.service.UserService;
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

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User findByLogin(String loginCode) throws Exception {
        User user = new User();
        user.setLoginCode(loginCode);
        Example<User> example = Example.of(user);
        Optional<User> one = userDao.findOne(example);
        if(one.isPresent()){
            return one.get();
        }
        return null;
    }

    @Override
    public Result findByName(User user,int pageNow, int pageSize) {
        Result result = new Result();
        PageRequest p = PageRequest.of(pageNow - 1, pageSize);
        ExampleMatcher matcher = ExampleMatcher.matching()
                // ExampleMatcher.GenericPropertyMatcher::contains  lambda表达式
                //contains()  全部模糊匹配  startsWith()  前部精确后部模糊   endsWith()  后部精确前部模糊
                //propertyPath 参数是指表字段 大写自动转下划线
                .withMatcher("loginCode",ExampleMatcher.GenericPropertyMatchers.contains())
                //.withIgnorePaths()  忽略字段，不管输入什么值都不加入查询条件
                //.withIgnoreNullValues()  忽略空值
                .withIgnoreNullValues();
        Example<User> example = Example.of(user,matcher);
        Page<User> all = userDao.findAll(example, p);
        if(all != null){
            result.setData(all);
            result.setMsg(Result.MSG_SUCCESS);
            result.setCode(Result.CODE_SUCCESS);
        }else {
            result.setMsg(Result.MSG_ERROR);
            result.setCode(Result.CODE_ERROR);
        }
        return result;
    }
}
