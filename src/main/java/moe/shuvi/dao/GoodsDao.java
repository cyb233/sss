package moe.shuvi.dao;

import moe.shuvi.model.Goods;
import moe.shuvi.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * @author qjy
 */
public interface GoodsDao extends JpaRepository<Goods,Integer>, JpaSpecificationExecutor<Order>  {

    @Modifying
    @Query(value = "update s_goods set del = 0 where id = ?1",nativeQuery = true)
    int deleteByGoods(int id);
}
