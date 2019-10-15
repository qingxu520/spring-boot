package co.goho.qingxu.easy.service.impl;

import co.goho.qingxu.easy.bean.SysMenu;
import co.goho.qingxu.easy.dao.SysMenuRepository;
import co.goho.qingxu.easy.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuRepository sysMenuRepository;

    @Override
    public void save(SysMenu sysMenu) {
        sysMenu.inParst();
        sysMenuRepository.save(sysMenu);
    }

    @Override
    public void update(SysMenu sysMenu) {
        sysMenu.upParst();
        sysMenuRepository.saveAndFlush(sysMenu);
    }

    @Override
    public void deleteById(String id) {
        sysMenuRepository.deleteById(id);
    }

    @Override
    public SysMenu findById(String id) {
        Optional<SysMenu> optionalT = sysMenuRepository.findById(id);
        return optionalT.isPresent() ? optionalT.get(): null;
    }

    @Override
    public List<SysMenu> findList(SysMenu sysMenu) {
        List<SysMenu> list = new ArrayList<>();
        if(sysMenu==null){
            list=sysMenuRepository.findAll();
        }else {
            Example<SysMenu> example = Example.of(sysMenu);
            list=sysMenuRepository.findAll(example);
        }
        return list;
    }

    @Override
    public Page<SysMenu> findPage(SysMenu sysMenu, Pageable pageable) {
        Page<SysMenu> page;
        Example<SysMenu> example = Example.of(sysMenu);
        page=sysMenuRepository.findAll(example,pageable);
        return page;
    }
}
