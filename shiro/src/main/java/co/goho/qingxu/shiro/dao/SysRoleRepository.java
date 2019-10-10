package co.goho.qingxu.shiro.dao;

import co.goho.qingxu.shiro.bean.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysRoleRepository extends JpaRepository<SysRole,String> {
}
