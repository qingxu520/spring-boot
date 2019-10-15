package co.goho.qingxu.easy.dao;

import co.goho.qingxu.easy.bean.SysLogininfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysLogininfoRepository extends JpaRepository<SysLogininfo,String> {
}
