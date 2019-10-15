package co.goho.qingxu.easy.service;

import co.goho.qingxu.easy.bean.SysOperLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SysOperLogService {

    /**
     * 保存SysOperLog
     * @param sysOperLog
     */
    void save(SysOperLog sysOperLog);
    
    /**
     * 修改
     * @param sysOperLog
     */
    void update(SysOperLog sysOperLog);

    /**
     * 删除
     * @param id
     */
    void deleteById(String id);

    /**
     * 通过ID查询
     * @param id
     * @return
     */
    SysOperLog findById(String id);

    /**
     * 查询
     * @param sysOperLog
     * @return
     */
    List<SysOperLog> findList(SysOperLog sysOperLog);

    /**
     * 分页查询
     * @param pageable
     * @return
     */
    Page<SysOperLog> findPage(SysOperLog sysOperLog, Pageable pageable);


}
