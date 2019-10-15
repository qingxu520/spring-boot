package co.goho.qingxu.easy.service.impl;

import co.goho.qingxu.easy.bean.SysDict;
import co.goho.qingxu.easy.dao.SysDictRepository;
import co.goho.qingxu.easy.service.SysDictService;
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
public class SysDictServiceImpl implements SysDictService {

    @Autowired
    private SysDictRepository sysDictRepository;

    @Override
    public void save(SysDict sysDict) {
        sysDict.inParst();
        sysDictRepository.save(sysDict);
    }

    @Override
    public void update(SysDict sysDict) {
        sysDict.upParst();
        sysDictRepository.saveAndFlush(sysDict);
    }

    @Override
    public void deleteById(String id) {
        sysDictRepository.deleteById(id);
    }

    @Override
    public SysDict findById(String id) {
        Optional<SysDict> optionalT = sysDictRepository.findById(id);
        return optionalT.isPresent() ? optionalT.get(): null;
    }

    @Override
    public SysDict findBytypeAndValue(String type, String value) {
        return sysDictRepository.findByTypeAndValue(type,value);
    }

    @Override
    public List<SysDict> findList(SysDict sysDict) {
        List<SysDict> dictList = new ArrayList<>();
        Sort sort = new Sort(Sort.Direction.ASC, "orderNum");
        if(sysDict==null){
            dictList=sysDictRepository.findAll(sort);
        }else {
            Example<SysDict> example = Example.of(sysDict);
            dictList=sysDictRepository.findAll(example,sort);
        }
        return dictList;
    }

    @Override
    public Page<SysDict> findPage(SysDict sysDict, Pageable pageable) {
        Page<SysDict> page;
        if(sysDict==null){
            page=sysDictRepository.findAll(pageable);
        }else {
            Example<SysDict> example = Example.of(sysDict);
            page=sysDictRepository.findAll(example,pageable);
        }
        return page;
    }
}
