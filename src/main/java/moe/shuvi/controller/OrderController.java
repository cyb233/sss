package moe.shuvi.controller;

import moe.shuvi.service.OrderService;
import moe.shuvi.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/list")
    public Result findAll() throws Exception {
        Result all = orderService.findAll();
        return all;
    }
}
