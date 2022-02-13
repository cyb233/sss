package moe.shuvi;

import moe.shuvi.model.Order;
import moe.shuvi.model.User;
import moe.shuvi.service.OrderService;
import moe.shuvi.utils.Result;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class OrderTest {

    @Autowired
    private OrderService orderService;
    @Test
    public void findAll()throws Exception{
        User user = new User();
        user.setLoginCode("1234567");
        Result all = orderService.findAll(user, 2, 1, 5);
        Page<Order> data = (Page<Order>)all.getData();
        System.out.println(data.getContent());
    }
}
