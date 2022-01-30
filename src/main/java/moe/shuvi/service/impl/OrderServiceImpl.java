package moe.shuvi.service.impl;

import moe.shuvi.dao.OrderDao;
import moe.shuvi.model.Order;
import moe.shuvi.service.OrderService;
import moe.shuvi.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Override
    public Result findAll() {
        List<Order> all = orderDao.findAll();
        Result result = new Result();
        result.setData(all);
        return result;
    }
}
