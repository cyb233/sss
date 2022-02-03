package moe.shuvi.service;

import moe.shuvi.model.Role;
import moe.shuvi.model.User;
import moe.shuvi.utils.Result;

public interface RoleService {
    Result findByPage(Role role) throws Exception;

    Result addOrUpdateRole(Role role)throws Exception;

    Result removeUserBYId(int id)throws Exception;
}
