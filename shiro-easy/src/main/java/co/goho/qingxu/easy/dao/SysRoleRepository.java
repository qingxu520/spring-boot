package co.goho.qingxu.easy.dao;

import co.goho.qingxu.easy.bean.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysRoleRepository extends JpaRepository<SysRole,String> {
}
