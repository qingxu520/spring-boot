package co.goho.qingxu.easy.service.impl;

import co.goho.qingxu.easy.bean.SysLogininfo;
import co.goho.qingxu.easy.dao.SysLogininfoRepository;
import co.goho.qingxu.easy.service.SysLogininfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SysLogininfoServiceImpl implements SysLogininfoService {

    @Autowired
    private SysLogininfoRepository sysLogininfoRepository;

    @Override
    public void save(SysLogininfo sysLogininfo) {
        sysLogininfo.inParst();
        sysLogininfoRepository.save(sysLogininfo);
    }

    @Override
    public void update(SysLogininfo sysLogininfo) {
        sysLogininfo.upParst();
        sysLogininfoRepository.saveAndFlush(sysLogininfo);
    }

    @Override
    public void deleteById(String id) {
        sysLogininfoRepository.deleteById(id);
    }

    @Override
    public SysLogininfo findById(String id) {
        Optional<SysLogininfo> optionalT = sysLogininfoRepository.findById(id);
        return optionalT.isPresent() ? optionalT.get(): null;
    }

    @Override
    public List<SysLogininfo> findList(SysLogininfo sysLogininfo) {
        List<SysLogininfo> list = new ArrayList<>();
        if(sysLogininfo==null){
            list=sysLogininfoRepository.findAll();
        }else {
            Example<SysLogininfo> example = Example.of(sysLogininfo);
            list=sysLogininfoRepository.findAll(example);
        }
        return list;
    }

    @Override
    public Page<SysLogininfo> findPage(SysLogininfo sysLogininfo, Pageable pageable) {
        Page<SysLogininfo> page;
        Example<SysLogininfo> example = Example.of(sysLogininfo);
        page=sysLogininfoRepository.findAll(example,pageable);
        return page;
    }
}
