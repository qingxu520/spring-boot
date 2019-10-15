package co.goho.qingxu.easy.dao;

import co.goho.qingxu.easy.bean.SysDict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysDictRepository extends JpaRepository<SysDict,String> {

    SysDict findByTypeAndValue(String type,String value);
}
