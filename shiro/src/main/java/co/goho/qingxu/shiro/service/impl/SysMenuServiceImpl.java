package co.goho.qingxu.shiro.service.impl;

import co.goho.qingxu.shiro.dao.SysMenuRepository;
import co.goho.qingxu.shiro.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuRepository sysMenuRepository;
}
