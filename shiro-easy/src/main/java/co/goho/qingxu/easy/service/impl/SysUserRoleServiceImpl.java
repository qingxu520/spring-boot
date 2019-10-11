package co.goho.qingxu.easy.service.impl;

import co.goho.qingxu.easy.dao.SysUserRoleRepository;
import co.goho.qingxu.easy.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {

    @Autowired
    private SysUserRoleRepository sysUserRoleRepository;
}
