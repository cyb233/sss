package moe.shuvi.dao;

import moe.shuvi.model.Goods;
import moe.shuvi.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author qjy
 */
public interface GoodsDao extends JpaRepository<Goods,Integer>, JpaSpecificationExecutor<Order>  {
}
