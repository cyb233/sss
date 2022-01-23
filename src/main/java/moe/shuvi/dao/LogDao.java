package moe.shuvi.dao;



import moe.shuvi.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @ClassName StudentDao
 * @Description TODO
 * @Author Administrator
 * @Date: 2022/1/5 15:25
 * @Version 1.0
 */
public interface LogDao extends JpaRepository<Log,Integer>, JpaSpecificationExecutor<Log> {
}
