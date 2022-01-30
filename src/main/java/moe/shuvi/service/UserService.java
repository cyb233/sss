package moe.shuvi.service;

import moe.shuvi.dao.UserDao;
import moe.shuvi.model.User;
import moe.shuvi.utils.Result;
import org.springframework.stereotype.Service;


public interface UserService {

    User findByLogin(User user) throws Exception;

    User selectByLoginCode(String loginCode) throws Exception;

    Result findByName(User user, int pageNow, int pageSize) throws Exception;
}
