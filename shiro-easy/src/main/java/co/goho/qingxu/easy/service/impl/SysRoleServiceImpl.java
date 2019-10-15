package co.goho.qingxu.easy.service.impl;

import co.goho.qingxu.easy.bean.SysRole;
import co.goho.qingxu.easy.dao.SysRoleRepository;
import co.goho.qingxu.easy.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleRepository sysRoleRepository;

    @Override
    public void save(SysRole data) {
        data.inParst();
        sysRoleRepository.save(data);
    }

    @Override
    public void update(SysRole data) {
        data.upParst();
        sysRoleRepository.saveAndFlush(data);
    }

    @Override
    public void deleteById(String id) {
        sysRoleRepository.deleteById(id);
    }

    @Override
    public SysRole findById(String id) {
        Optional<SysRole> optionalT = sysRoleRepository.findById(id);
        return optionalT.isPresent() ? optionalT.get(): null;
    }

    @Override
    public List<SysRole> findList(SysRole data) {
        return null;
    }

    @Override
    public Page<SysRole> findPage(SysRole data, Pageable pageable) {
        return null;
    }
}
