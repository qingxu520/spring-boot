package co.goho.qingxu.easy.dao;

import co.goho.qingxu.easy.bean.SysConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysConfigRepository extends JpaRepository<SysConfig,String> {

    SysConfig findByConfigKey(String configKey);
}
