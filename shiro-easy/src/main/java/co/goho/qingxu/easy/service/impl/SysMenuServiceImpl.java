package co.goho.qingxu.easy.service.impl;

import co.goho.qingxu.easy.dao.SysMenuRepository;
import co.goho.qingxu.easy.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuRepository sysMenuRepository;
}
