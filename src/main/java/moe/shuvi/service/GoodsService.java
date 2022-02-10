package moe.shuvi.service;

import moe.shuvi.model.Goods;
import moe.shuvi.utils.Result;

public interface GoodsService {

    Result findByPage(Goods goods,int pageNow,int pageSize) throws Exception;

    Result addOrUpdateGoods(Goods goods) throws Exception;

    Result removeGoodsById(int id) throws Exception;
}
