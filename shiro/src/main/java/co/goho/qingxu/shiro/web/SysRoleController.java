package co.goho.qingxu.shiro.web;

import co.goho.qingxu.shiro.common.bean.BaseController;
import co.goho.qingxu.shiro.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SysRoleController extends BaseController {

    @Autowired
    private SysRoleService sysRoleService;

}
