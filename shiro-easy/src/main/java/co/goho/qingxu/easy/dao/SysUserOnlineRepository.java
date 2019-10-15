package co.goho.qingxu.easy.dao;

import co.goho.qingxu.easy.bean.SysUserOnline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SysUserOnlineRepository extends JpaRepository<SysUserOnline,String> {

    /**
     * 查询过期会话集合
     *
     * @param lastAccessTime 过期时间
     * @return 会话集合
     */
    List<SysUserOnline> findByLastAccessTimeGreaterThan(Date lastAccessTime);
}
