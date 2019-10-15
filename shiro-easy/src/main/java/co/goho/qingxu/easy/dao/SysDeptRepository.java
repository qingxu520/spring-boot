package co.goho.qingxu.easy.dao;

import co.goho.qingxu.easy.bean.SysDept;
import co.goho.qingxu.easy.bean.SysMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysDeptRepository extends JpaRepository<SysDept,String> {
}
