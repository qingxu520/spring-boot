package co.goho.qingxu.easy.service.impl;

import co.goho.qingxu.easy.dao.SysUserRepository;
import co.goho.qingxu.easy.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserRepository sysUserRepository;
}
