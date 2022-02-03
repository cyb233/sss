package moe.shuvi.dao;


import moe.shuvi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UserDao extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User> {

    @Modifying
    @Query(value = "delete from s_user where id=?1",nativeQuery = true)
    int deleteByUser(int id);
}
