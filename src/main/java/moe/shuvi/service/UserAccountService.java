package moe.shuvi.service;

import moe.shuvi.dao.UserAccountDao;
import moe.shuvi.model.User;
import moe.shuvi.utils.Result;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public interface UserAccountService {

    Result findByAccount(User user,int pageNow,int pageSize);


}
