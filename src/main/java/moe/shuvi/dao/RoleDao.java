package moe.shuvi.dao;

import moe.shuvi.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RoleDao extends JpaRepository<Role,Integer>, JpaSpecificationExecutor<Role> {
}
