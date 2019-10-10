package co.goho.qingxu.shiro.service.impl;

import co.goho.qingxu.shiro.dao.SysUserRepository;
import co.goho.qingxu.shiro.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserRepository sysUserRepository;
}
