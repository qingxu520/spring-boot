package co.goho.qingxu.shiro.dao;

import co.goho.qingxu.shiro.bean.SysMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysMenuRepository extends JpaRepository<SysMenu,String> {
}
