package moe.shuvi;

import moe.shuvi.dao.GoodsDao;
import moe.shuvi.model.Goods;
import moe.shuvi.service.GoodsService;
import moe.shuvi.utils.Result;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

@SpringBootTest
public class GoodsTest {
    @Autowired
    private GoodsService goodsService;
    @Test
    public void findAll() throws Exception{
        Goods goods = new Goods();
        goods.setGoodsName("123");
        Result byPage = goodsService.findByPage(goods, 2, 3);
        Page<Goods> newPage = (Page<Goods>) byPage.getData();
        System.out.println("===>"+newPage.getContent());
    }
}
