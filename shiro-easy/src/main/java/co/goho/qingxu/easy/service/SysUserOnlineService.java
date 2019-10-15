package co.goho.qingxu.easy.service;

import co.goho.qingxu.easy.bean.SysUserOnline;

import java.util.Date;
import java.util.List;

public interface SysUserOnlineService {
    /**
     * 查询过期会话
     * @param lastAccessTime
     * @return
     */
    List<SysUserOnline> findByLastAccessTimeGreaterThan(Date lastAccessTime);

    /**
     * 通过会话序号删除信息
     *
     * @param sessions 会话ID集合
     * @return 在线用户信息
     */
    void batchDeleteOnline(List<SysUserOnline> sessions);

    /**
     * 通过ID删除会话
     * @param id
     */
    void deleteById(String id);

    /**
     * 通过ID查询会话
     * @param id
     * @return
     */
    SysUserOnline findById(String id);

    /**
     * 保存会话
     * @param sysUserOnline
     */
    void save(SysUserOnline sysUserOnline);



}
