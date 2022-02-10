package moe.shuvi.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import moe.shuvi.log.LogAnnotation;
import moe.shuvi.model.Goods;
import moe.shuvi.service.GoodsService;
import moe.shuvi.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "GoodsController",description = "商品登录登出汇总",tags = "GoodsController")
@RestController
@RequestMapping("/goods")
//跨域允许
@CrossOrigin
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNow", value = "当前页", required = true ,dataType = "int"),
            @ApiImplicitParam(name = "pageSize", value = "当页容量", required = true ,dataType = "int")
    })
    @LogAnnotation(title = "商品模块",action = "商品查询")
    @RequestMapping("/page")
    public Result findAll(@RequestBody Goods goods, int pageNow, @RequestParam int pageSize) throws Exception{
        Result result = goodsService.findByPage(goods, pageNow, pageSize);
        return result;
    }

    @LogAnnotation(title = "商品模块",action = "商品注册")
    @RequestMapping("/addGoods")
    public Result addGoods(@RequestBody Goods goods)throws Exception{
        Result result = goodsService.addOrUpdateGoods(goods);
        return result;
    }
    @LogAnnotation(title = "商品模块",action = "商品删除")
    @RequestMapping("/remove")
    public Result removeById(@RequestParam int id)throws Exception{
        Result result = goodsService.removeGoodsById(id);
        return result;
    }
    @LogAnnotation(title = "商品模块",action = "商品修改")
    @RequestMapping("/update")
    public Result modify(@RequestBody Goods goods)throws Exception{
        Result result = goodsService.addOrUpdateGoods(goods);
        return result;
    }
}
