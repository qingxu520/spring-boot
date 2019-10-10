package co.goho.qingxu.shiro.service.impl;

import co.goho.qingxu.shiro.dao.SysRoleMenuRepository;
import co.goho.qingxu.shiro.service.SysRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysRoleMenuServiceImpl implements SysRoleMenuService {

    @Autowired
    private SysRoleMenuRepository sysRoleMenuRepository;
}
