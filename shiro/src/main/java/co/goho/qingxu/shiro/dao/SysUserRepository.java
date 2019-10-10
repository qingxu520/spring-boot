package co.goho.qingxu.shiro.dao;

import co.goho.qingxu.shiro.bean.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserRepository extends JpaRepository<SysUser, String> {
    SysUser findByUserName(String userName);
    SysUser findByIdcard(String idcard);
    List<SysUser> findByNameLike(String name);
}
