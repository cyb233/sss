package moe.shuvi.dao;

import moe.shuvi.model.Account;
import moe.shuvi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface AccountDao extends JpaRepository<Account,Integer>, JpaSpecificationExecutor<Account> {
    @Modifying
    @Query(value = "update s_account set del = 0 where id = ?1",nativeQuery = true)
    int deleteByAccount(int id);

    @Modifying
    @Query(value = "update s_account set money=money+?2 where accounts = ?1",nativeQuery = true)
    int addMoney(String account,Double money)throws Exception;

    @Modifying
    @Query(value = "update s_account set money=money-?2 where accounts = ?1",nativeQuery = true)
    int deleteMoney(String account,Double money)throws Exception;
}
