package co.goho.qingxu.easy.service;

import co.goho.qingxu.easy.bean.SysLogininfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SysLogininfoService {
    /**
     * 保存SysLogininfo
     * @param sysLogininfo
     */
    void save(SysLogininfo sysLogininfo);

    /**
     * 修改
     * @param sysLogininfo
     */
    void update(SysLogininfo sysLogininfo);

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
    SysLogininfo findById(String id);

    /**
     * 查询
     * @param sysLogininfo
     * @return
     */
    List<SysLogininfo> findList(SysLogininfo sysLogininfo);

    /**
     * 分页查询
     * @param pageable
     * @return
     */
    Page<SysLogininfo> findPage(SysLogininfo sysLogininfo, Pageable pageable);


}
