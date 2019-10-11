package co.goho.qingxu.easy.dao;

import co.goho.qingxu.easy.bean.SysMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysMenuRepository extends JpaRepository<SysMenu,String> {
}
