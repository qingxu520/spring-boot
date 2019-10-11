package co.goho.qingxu.easy.service.impl;

import co.goho.qingxu.easy.dao.SysRoleRepository;
import co.goho.qingxu.easy.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleRepository sysRoleRepository;
}
