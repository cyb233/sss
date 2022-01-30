package moe.shuvi.dao;

import moe.shuvi.model.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author qjy
 */
public interface GoodsDao extends JpaRepository<Goods,Integer> {
}
