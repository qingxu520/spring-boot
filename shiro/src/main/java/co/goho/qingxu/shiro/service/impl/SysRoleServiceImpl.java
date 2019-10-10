package co.goho.qingxu.shiro.service.impl;

import co.goho.qingxu.shiro.dao.SysRoleRepository;
import co.goho.qingxu.shiro.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleRepository sysRoleRepository;
}
