package moe.shuvi.dao;


import moe.shuvi.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OrderDao extends JpaRepository<Order,Integer>, JpaSpecificationExecutor<Order> {
}
