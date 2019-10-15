package co.goho.qingxu.easy.web;

import co.goho.qingxu.easy.conmmon.base.BaseController;
import co.goho.qingxu.easy.service.SysRoleService;
import co.goho.qingxu.easy.service.SysUserService;
import co.goho.qingxu.easy.shiro.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户信息
 * 
 * @author ruoyi
 */
@Controller
@RequestMapping("/system/user")
public class SysUserController extends BaseController {
    private String prefix = "system/user";

    @Autowired
    private SysUserService userService;

    @Autowired
    private SysRoleService roleService;

    @Autowired
    private PasswordService passwordService;
}