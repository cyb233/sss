package moe.shuvi.dao;


import moe.shuvi.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserAccountDao extends JpaRepository<UserAccount,Integer>, JpaSpecificationExecutor<UserAccount> {
    @Modifying
    @Query(value = "update s_userAccount set del = 0 where id = ?1",nativeQuery = true)
    int deleteByUserAccount(int id);
}
