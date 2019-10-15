package co.goho.qingxu.easy.service;

import co.goho.qingxu.easy.bean.SysDept;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * SysDeptService
 */
public interface SysDeptService {

    /**
     * 保存SysDept
     * @param sysDept
     */
    void save(SysDept sysDept);

    /**
     * 修改
     * @param sysDept
     */
    void update(SysDept sysDept);

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
    SysDept findById(String id);

    /**
     * 查询
     * @param sysDept
     * @return
     */
    List<SysDept> findList(SysDept sysDept);

    /**
     * 分页查询
     * @param pageable
     * @return
     */
    Page<SysDept> findPage(SysDept sysDept,Pageable pageable);

}
