package co.goho.qingxu.easy.web;

import co.goho.qingxu.easy.conmmon.base.BaseController;
import co.goho.qingxu.easy.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SysMenuController extends BaseController {

    @Autowired
    private SysMenuService sysMenuService;
}
