package moe.shuvi.dao;

import moe.shuvi.model.Dictionary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface DictionaryDao extends JpaRepository<Dictionary,Integer>, JpaSpecificationExecutor<Dictionary> {

    @Modifying
    @Query(value = "update d_dictionary set del = 0 where id = ?1",nativeQuery = true)
    int deleteByDictionary(int id);
}
