package co.goho.qingxu.easy.service;

import co.goho.qingxu.easy.bean.SysRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SysRoleService {

    /**
     * 保存SysRole
     * @param data
     */
    void save(SysRole data);

    /**
     * 修改
     * @param data
     */
    void update(SysRole data);

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
    SysRole findById(String id);

    /**
     * 查询
     * @param data
     * @return
     */
    List<SysRole> findList(SysRole data);

    /**
     * 分页查询
     * @param pageable
     * @return
     */
    Page<SysRole> findPage(SysRole data, Pageable pageable);


}
