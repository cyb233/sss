package moe.shuvi.service.impl;

import moe.shuvi.dao.OrderDao;
import moe.shuvi.dao.UserDao;
import moe.shuvi.model.Order;
import moe.shuvi.model.User;
import moe.shuvi.service.OrderService;
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

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private UserService userService;
    /**
     * 带有多表查询
     * @param user     搜索的参数
     * @param orderCode 判断是收获用户还是买单用户
     * @param pageNow  分页的当前页
     * @param pageSize 分页的页数
     * @return 返回Result
     * @author 小张
     */
    @Override
    public Result findAll(User user,int orderCode, int pageNow, int pageSize) throws Exception {
        Result result = new Result();
        Order order = new Order();
        User newUser = userService.findByLogin(user);
        PageRequest p = PageRequest.of(pageNow - 1, pageSize);
        String userId = "";
        if(orderCode == 1){
            userId = "pickUserId";
            order.setPickUserId(newUser.getId());
        }else {
            order.setBuyUserId(newUser.getId());
            userId = "buyUserId";
        }
        //复杂查询的分装类
        ExampleMatcher matcher = ExampleMatcher.matching()
                // ExampleMatcher.GenericPropertyMatcher::contains  lambda表达式
                //contains()  全部模糊匹配  startsWith()  前部精确后部模糊   endsWith()  后部精确前部模糊
                //propertyPath 参数是指表字段 大写自动转下划线
                .withMatcher(userId, ExampleMatcher.GenericPropertyMatchers.contains())
                 //.withIgnorePaths()  忽略字段，不管输入什么值都不加入查询条件
                //.withIgnoreNullValues()  忽略空值
                .withIgnoreNullValues();
        Example<Order> example = Example.of(order, matcher);
        Page<Order> all = orderDao.findAll(example, p);
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
     * @param order 添加或修改参数
     * @return 成功与否
     * @throws Exception
     * @author 小张
     */
    @Transactional
    @Override
    public Result addOrUpdateOrder(Order order) throws Exception {
        Result result = new Result();
        Order save = null;
        if (order.getId() != null) {
            Optional<Order> originalORder = orderDao.findById(order.getId());
//            System.out.println("-----" + originalUser.get());
            Order newOrder = originalORder.get();
            if (originalORder.isPresent()) {
                JpaUtil.copyNotNullProperties(order, newOrder);
            }
//            System.out.println("===>" + newUser);
            save = orderDao.saveAndFlush(newOrder);
        } else {
            save = orderDao.saveAndFlush(order);
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
    public Result removeById(int id) throws Exception {
        Result result = new Result();
        int i = orderDao.deleteByOrder(id);
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
