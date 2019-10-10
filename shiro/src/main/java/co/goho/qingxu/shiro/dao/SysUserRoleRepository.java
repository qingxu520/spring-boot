package co.goho.qingxu.shiro.dao;

import co.goho.qingxu.shiro.bean.SysUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserRoleRepository extends JpaRepository<SysUserRole,String> {
}
