package co.goho.qingxu.easy.service.impl;

import co.goho.qingxu.easy.bean.SysUser;
import co.goho.qingxu.easy.dao.SysUserRepository;
import co.goho.qingxu.easy.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserRepository sysUserRepository;

    @Override
    public SysUser findByUserName(String userName) {
        return sysUserRepository.findByUserName(userName);
    }

    @Override
    public SysUser findByPhone(String phone) {
        return sysUserRepository.findByPhone(phone);
    }

    @Override
    public SysUser findByEmail(String email) {
        return sysUserRepository.findByEmail(email);
    }

    @Override
    public SysUser findByIdcard(String idcard) {
        return sysUserRepository.findByIdcard(idcard);
    }

    @Override
    public List<SysUser> findByNameLike(String name) {
        return sysUserRepository.findByNameLike(name);
    }

    @Override
    public void updateUserInfo(SysUser user) {
        user.upParst();
        sysUserRepository.saveAndFlush(user);
    }

    @Override
    public void save(SysUser data) {
        data.inParst();
        sysUserRepository.save(data);
    }

    @Override
    public void deleteById(String id) {
        sysUserRepository.deleteById(id);
    }

    @Override
    public SysUser findById(String id) {
        return sysUserRepository.findById(id).get();
    }

    @Override
    public List<SysUser> findList(SysUser data) {
        List<SysUser> list = new ArrayList<>();
        /*if(data==null){
            list=sysUserRepository.findAll();
        }else {*/
            Example<SysUser> example = Example.of(data);
            list=sysUserRepository.findAll(example);
        //}
        return list;
    }

    @Override
    public Page<SysUser> findPage(SysUser data, Pageable pageable) {
        return null;
    }
}
