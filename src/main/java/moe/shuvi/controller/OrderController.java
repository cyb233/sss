package moe.shuvi.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import moe.shuvi.log.LogAnnotation;
import moe.shuvi.model.Order;
import moe.shuvi.model.User;
import moe.shuvi.service.OrderService;
import moe.shuvi.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "OrderController", description = "订单接口汇总", tags = "OrderController")
@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 注意这个接口只能查询接收用户
     *
     * @param user
     * @return
     * @throws Exception
     * @author 小张
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "User", value = "查询收货用户(可模糊查询)", required = true, dataType = "User"),
    })
    /**
     *
     *  注意这个接口只能查询接收用户
     * @param user
     * @return
     * @throws Exception
     * @author 小张
     */
    @LogAnnotation(title = "订单模块", action = "收货用户订单查询")
    @RequestMapping("/pickList")
    public Result findPick(@RequestBody User user) throws Exception {
        return orderService.findAll(user, Result.ORDER_PICK, user.getPageNow(), user.getPageSize());
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "User", value = "查询买单用户(可模糊查询)", required = true, dataType = "User"),
    })
    @LogAnnotation(title = "订单模块", action = "买单用户订单查询")
    @RequestMapping("/buyList")
    public Result findBuy(@RequestBody User user) throws Exception {
        return orderService.findAll(user, Result.ORDER_BUY, user.getPageNow(), user.getPageSize());
    }

    @LogAnnotation(title = "订单模块", action = "订单添加")
    @RequestMapping("/add")
    public Result addOrder(@RequestBody Order order) throws Exception {
        return orderService.addOrUpdateOrder(order);
    }

    @LogAnnotation(title = "订单模块", action = "订单修改")
    @RequestMapping("/modify")
    public Result modify(@RequestBody Order order) throws Exception {
        return orderService.addOrUpdateOrder(order);
    }

    @LogAnnotation(title = "订单模块", action = "订单删除")
    @RequestMapping("/remove")
    public Result remove(@RequestParam int id) throws Exception {
        return orderService.removeById(id);
    }
}
