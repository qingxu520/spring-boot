package co.goho.qingxu.easy.service;

import co.goho.qingxu.easy.bean.SysMenu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SysMenuService {

    /**
     * 保存SysMenu
     * @param sysMenu
     */
    void save(SysMenu sysMenu);

    /**
     * 修改
     * @param sysMenu
     */
    void update(SysMenu sysMenu);

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
    SysMenu findById(String id);

    /**
     * 查询
     * @param sysMenu
     * @return
     */
    List<SysMenu> findList(SysMenu sysMenu);

    /**
     * 分页查询
     * @param pageable
     * @return
     */
    Page<SysMenu> findPage(SysMenu sysMenu, Pageable pageable);

}
