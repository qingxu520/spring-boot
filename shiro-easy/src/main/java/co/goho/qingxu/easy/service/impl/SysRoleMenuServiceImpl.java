package co.goho.qingxu.easy.service.impl;

import co.goho.qingxu.easy.dao.SysRoleMenuRepository;
import co.goho.qingxu.easy.service.SysRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysRoleMenuServiceImpl implements SysRoleMenuService {

    @Autowired
    private SysRoleMenuRepository sysRoleMenuRepository;
}
