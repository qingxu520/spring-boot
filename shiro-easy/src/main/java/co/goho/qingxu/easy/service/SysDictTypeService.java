package co.goho.qingxu.easy.service;

import co.goho.qingxu.easy.bean.SysDept;
import co.goho.qingxu.easy.bean.SysDict;
import co.goho.qingxu.easy.bean.SysDictType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SysDictTypeService {

    /**
     * 保存
     * @param sysDictType
     */
    void save(SysDictType sysDictType);

    /**
     * 修改
     * @param sysDictType
     */
    void update(SysDictType sysDictType);

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
    SysDictType findById(String id);

    /**
     * 通过字典类型查询
     * @param type
     * @return
     */
    SysDictType findByType(String type);
    /**
     * 查询
     * @param sysDictType
     * @return
     */
    List<SysDictType> findList(SysDictType sysDictType);

    /**
     * 分页查询
     * @param pageable
     * @return
     */
    Page<SysDictType> findPage(SysDictType sysDictType, Pageable pageable);

}
