package co.goho.qingxu.easy.service.impl;

import co.goho.qingxu.easy.bean.SysConfig;
import co.goho.qingxu.easy.dao.SysConfigRepository;
import co.goho.qingxu.easy.dao.SysDeptRepository;
import co.goho.qingxu.easy.service.SysConfigService;
import co.goho.qingxu.easy.service.SysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SysConfigServiceImpl implements SysConfigService {

    @Autowired
    private SysConfigRepository sysConfigRepository;

    @Override
    public void save(SysConfig sysConfig) {
        sysConfig.inParst();
        sysConfigRepository.save(sysConfig);
    }

    @Override
    public void update(SysConfig sysConfig) {
        sysConfig.upParst();
        sysConfigRepository.saveAndFlush(sysConfig);
    }

    @Override
    public void deleteById(String id) {
        sysConfigRepository.deleteById(id);
    }

    @Override
    public SysConfig findById(String id) {
        Optional<SysConfig> optionalT = sysConfigRepository.findById(id);
        return optionalT.isPresent() ? optionalT.get(): null;
    }

    @Override
    public SysConfig findByConfigKey(String configKey) {
        return sysConfigRepository.findByConfigKey(configKey);
    }

    @Override
    public List<SysConfig> findList(SysConfig sysConfig) {
        List<SysConfig> deptList = new ArrayList<>();
        Sort sort = new Sort(Sort.Direction.ASC, "orderNum");
        if(sysConfig==null){
            deptList=sysConfigRepository.findAll(sort);
        }else {
            Example<SysConfig> example = Example.of(sysConfig);
            deptList=sysConfigRepository.findAll(example,sort);
        }
        return deptList;
    }

    @Override
    public Page<SysConfig> findPage(SysConfig sysConfig,Pageable pageable) {
        Page<SysConfig> page;
        if(sysConfig==null){
            page=sysConfigRepository.findAll(pageable);
        }else {
            Example<SysConfig> example = Example.of(sysConfig);
            page=sysConfigRepository.findAll(example,pageable);
        }
        return page;
    }
}
