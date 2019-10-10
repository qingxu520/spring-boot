package co.goho.qingxu.shiro.controller;

import co.goho.qingxu.shiro.common.bean.BaseController;
import co.goho.qingxu.shiro.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SysMenuController extends BaseController {

    @Autowired
    private SysMenuService sysMenuService;
}
