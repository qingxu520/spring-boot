package co.goho.qingxu.easy.dao;

import co.goho.qingxu.easy.bean.SysUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserRoleRepository extends JpaRepository<SysUserRole,String> {
}
