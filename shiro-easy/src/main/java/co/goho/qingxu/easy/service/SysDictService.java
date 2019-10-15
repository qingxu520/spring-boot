package co.goho.qingxu.easy.service;

import co.goho.qingxu.easy.bean.SysDict;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SysDictService {

    /**
     * 保存
     * @param sysDict
     */
    void save(SysDict sysDict);

    /**
     * 修改
     * @param sysDict
     */
    void update(SysDict sysDict);

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
    SysDict findById(String id);

    /**
     * 通过字典类型和字典值查询字典标签
     * @param type
     * @param value
     * @return
     */
    SysDict findBytypeAndValue(String type,String value);

    /**
     * 查询
     * @param sysDict
     * @return
     */
    List<SysDict> findList(SysDict sysDict);

    /**
     * 分页查询
     * @param pageable
     * @return
     */
    Page<SysDict> findPage(SysDict sysDict, Pageable pageable);

}
