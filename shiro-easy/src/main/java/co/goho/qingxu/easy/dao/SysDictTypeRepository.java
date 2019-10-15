package co.goho.qingxu.easy.dao;

import co.goho.qingxu.easy.bean.SysDictType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysDictTypeRepository extends JpaRepository<SysDictType,String> {

    /**
     * 通过类型查询
     * @param type
     * @return
     */
    SysDictType findByType(String type);
}
