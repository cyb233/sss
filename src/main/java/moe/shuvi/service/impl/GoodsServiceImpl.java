package moe.shuvi.service.impl;

import moe.shuvi.dao.GoodsDao;
import moe.shuvi.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;
}
