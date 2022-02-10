package moe.shuvi.dao;


import moe.shuvi.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface OrderDao extends JpaRepository<Order,Integer>, JpaSpecificationExecutor<Order> {

    @Modifying
    @Query(value = "update s_order set del = 0 where id = ?1",nativeQuery = true)
    int deleteByOrder(int id);
}
