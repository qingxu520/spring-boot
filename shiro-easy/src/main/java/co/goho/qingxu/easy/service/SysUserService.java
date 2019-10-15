package co.goho.qingxu.easy.service;

import co.goho.qingxu.easy.bean.SysUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * SysUserService
 */
public interface SysUserService {
    /**
     * 用户名查询用户
     * @param userName
     * @return
     */
    SysUser findByUserName(String userName);

    /**
     * 手机号查询用户
     * @param phone
     * @return
     */
    SysUser findByPhone(String phone);

    /**
     * 邮箱查询用户
     * @param email
     * @return
     */
    SysUser findByEmail(String email);

    /**
     * 身份证查询用户
     * @param idcard
     * @return
     */
    SysUser findByIdcard(String idcard);

    /**
     * 姓名模糊查询用户列表
     * @param name
     * @return
     */
    List<SysUser> findByNameLike(String name);

    /**
     *更新用户
     * @param user
     */
    void updateUserInfo(SysUser user);

    /**
     * 保存SysUser
     * @param data
     */
    void save(SysUser data);

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
    SysUser findById(String id);

    /**
     * 查询
     * @param data
     * @return
     */
    List<SysUser> findList(SysUser data);

    /**
     * 分页查询
     * @param pageable
     * @return
     */
    Page<SysUser> findPage(SysUser data, Pageable pageable);

}
