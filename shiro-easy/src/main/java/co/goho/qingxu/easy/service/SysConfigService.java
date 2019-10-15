package co.goho.qingxu.easy.service;

import co.goho.qingxu.easy.bean.SysConfig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * SysDeptService
 */
public interface SysConfigService {

    /**
     * 保存SysDept
     * @param sysConfig
     */
    void save(SysConfig sysConfig);

    /**
     * 修改
     * @param sysConfig
     */
    void update(SysConfig sysConfig);

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
    SysConfig findById(String id);

    /**
     * 通过ID查询
     * @param configKey
     * @return
     */
    SysConfig findByConfigKey(String configKey);

    /**
     * 查询
     * @param sysConfig
     * @return
     */
    List<SysConfig> findList(SysConfig sysConfig);

    /**
     * 分页查询
     * @param pageable
     * @return
     */
    Page<SysConfig> findPage(SysConfig sysConfig, Pageable pageable);

}
