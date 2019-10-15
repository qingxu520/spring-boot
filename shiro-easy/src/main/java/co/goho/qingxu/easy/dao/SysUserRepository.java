package co.goho.qingxu.easy.dao;

import co.goho.qingxu.easy.bean.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserRepository extends JpaRepository<SysUser, String> {

    SysUser findByUserName(String userName);

    SysUser findByPhone(String phone);

    SysUser findByEmail(String email);

    SysUser findByIdcard(String idcard);

    List<SysUser> findByNameLike(String name);
}
