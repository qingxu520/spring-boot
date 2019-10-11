package co.goho.qingxu.shiro.web;

import co.goho.qingxu.shiro.common.bean.BaseController;
import co.goho.qingxu.shiro.service.SysUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Api(tags = "用户管理接口")
@Controller
public class SysUserController extends BaseController {

    @Autowired
    private SysUserService sysUserService;
}
