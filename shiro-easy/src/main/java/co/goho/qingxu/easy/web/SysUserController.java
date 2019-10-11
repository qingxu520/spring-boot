package co.goho.qingxu.easy.web;

import co.goho.qingxu.easy.conmmon.base.BaseController;
import co.goho.qingxu.easy.service.SysUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Api(tags = "用户管理接口")
@Controller
public class SysUserController extends BaseController {

    @Autowired
    private SysUserService sysUserService;
}
