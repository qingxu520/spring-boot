package co.goho.qingxu.shiro.dao;

import co.goho.qingxu.shiro.bean.SysRoleMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysRoleMenuRepository extends JpaRepository<SysRoleMenu,String> {
}
