package moe.shuvi.service;


import moe.shuvi.model.Order;
import moe.shuvi.model.User;
import moe.shuvi.utils.Result;

public interface OrderService {

    Result findAll(User user, int orderCode, int pageNow, int pageSize) throws Exception;

    Result addOrUpdateOrder(Order order) throws Exception;

    Result removeById(int id) throws Exception;

}
