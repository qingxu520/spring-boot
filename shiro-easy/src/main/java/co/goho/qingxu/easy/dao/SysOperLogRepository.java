package co.goho.qingxu.easy.dao;

import co.goho.qingxu.easy.bean.SysOperLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysOperLogRepository extends JpaRepository<SysOperLog,String> {
}
