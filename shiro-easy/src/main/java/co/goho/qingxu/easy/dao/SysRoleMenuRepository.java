package co.goho.qingxu.easy.dao;

import co.goho.qingxu.easy.bean.SysRoleMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysRoleMenuRepository extends JpaRepository<SysRoleMenu,String> {
}
