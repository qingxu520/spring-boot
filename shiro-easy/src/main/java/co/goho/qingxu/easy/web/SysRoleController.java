package co.goho.qingxu.easy.web;

import co.goho.qingxu.easy.conmmon.base.BaseController;
import co.goho.qingxu.easy.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SysRoleController extends BaseController {

    @Autowired
    private SysRoleService sysRoleService;

}
