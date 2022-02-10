package moe.shuvi.service.impl;

import moe.shuvi.dao.GoodsDao;
import moe.shuvi.model.Goods;
import moe.shuvi.service.GoodsService;
import moe.shuvi.utils.JpaUtil;
import moe.shuvi.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    /**
     * @author qianjianyu
     * @param goods 搜索的参数
     * @param pageNow 分页的当前页
     * @param pageSize 分页的页数
     * @return 返回Result
     */
    @Transactional
    @Override
    public Result findByPage(Goods goods, int pageNow, int pageSize) throws Exception {
        Result result = new Result();
        PageRequest p = PageRequest.of(pageNow - 1, pageSize);
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("loginCode",ExampleMatcher.GenericPropertyMatchers.contains())
                .withIgnoreNullValues();
        Example<Goods> example = Example.of(goods,matcher);
        Page<Goods> all = goodsDao.findAll(example, p);
        if(all != null){
            result.setData(all);
            result.setMsg(Result.MSG_SUCCESS);
            result.setCode(Result.CODE_SUCCESS);
        }else {
            result.setMsg(Result.MSG_ERROR);
            result.setCode(Result.CODE_ERROR);
        }
        return result;
    }

    /**
     *  添加和修改公用一个方法,区别是有id则修改,无id则添加
     *  @author qianjianyu
     * @param goods 添加或修改参数
     * @return 成功与否
     * @throws Exception
     */
    @Transactional
    @Override
    public Result addOrUpdateGoods(Goods goods) throws Exception {
        Result result = new Result();
        Goods save = null;
        if (goods.getId() != null) {
            Optional<Goods> originalGoods = goodsDao.findById(goods.getId());
            Goods newGoods = originalGoods.get();
            if (originalGoods.isPresent()) {
                JpaUtil.copyNotNullProperties(goods, newGoods);
            }
            save = goodsDao.saveAndFlush(newGoods);
        } else {
            save = goodsDao.saveAndFlush(goods);
        }

        // goodsDao.save
        if(save != null){
            result.setData(save);
            result.setCode(Result.CODE_SUCCESS);
            result.setMsg(Result.MSG_SUCCESS);
        }else {
            result.setMsg(Result.MSG_SUCCESS);
            result.setCode(Result.CODE_ERROR);
        }
        return result;
    }

    /**
     * @author qianjianyu
     * @param id 删除参数,逻辑删除
     * @return 成功与否
     * @throws Exception
     */
    @Transactional
    @Override
    public Result removeGoodsById(int id) throws Exception {
        Result result = new Result();
        if(id >= 0){
            goodsDao.deleteById(id);
            result.setData(id);
            result.setCode(Result.CODE_SUCCESS);
            result.setMsg(Result.MSG_SUCCESS);
        }else {
            result.setCode(Result.CODE_ERROR);
            result.setMsg(Result.MSG_ERROR);
        }
        return result;
    }
}
