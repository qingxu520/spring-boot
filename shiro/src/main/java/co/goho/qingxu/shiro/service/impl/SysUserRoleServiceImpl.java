package co.goho.qingxu.shiro.service.impl;

import co.goho.qingxu.shiro.dao.SysUserRoleRepository;
import co.goho.qingxu.shiro.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {

    @Autowired
    private SysUserRoleRepository sysUserRoleRepository;
}
