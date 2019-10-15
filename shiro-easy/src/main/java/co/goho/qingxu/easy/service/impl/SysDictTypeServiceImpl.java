package co.goho.qingxu.easy.service.impl;

import co.goho.qingxu.easy.bean.SysDictType;
import co.goho.qingxu.easy.dao.SysDictTypeRepository;
import co.goho.qingxu.easy.service.SysDictTypeService;
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
public class SysDictTypeServiceImpl implements SysDictTypeService {

    @Autowired
    private SysDictTypeRepository sysDictTypeRepository;

    @Override
    public void save(SysDictType sysDictType) {
        sysDictType.inParst();
        sysDictTypeRepository.save(sysDictType);
    }

    @Override
    public void update(SysDictType sysDictType) {
        sysDictType.upParst();
        sysDictTypeRepository.saveAndFlush(sysDictType);
    }

    @Override
    public void deleteById(String id) {
        sysDictTypeRepository.deleteById(id);
    }

    @Override
    public SysDictType findById(String id) {
        Optional<SysDictType> optionalT = sysDictTypeRepository.findById(id);
        return optionalT.isPresent() ? optionalT.get(): null;    }

    @Override
    public SysDictType findByType(String type) {
        return sysDictTypeRepository.findByType(type);
    }

    @Override
    public List<SysDictType> findList(SysDictType sysDictType) {
        List<SysDictType> dictList = new ArrayList<>();
        Sort sort = new Sort(Sort.Direction.ASC, "orderNum");
        if(sysDictType==null){
            dictList=sysDictTypeRepository.findAll(sort);
        }else {
            Example<SysDictType> example = Example.of(sysDictType);
            dictList=sysDictTypeRepository.findAll(example,sort);
        }
        return dictList;
    }

    @Override
    public Page<SysDictType> findPage(SysDictType sysDictType, Pageable pageable) {
        Page<SysDictType> page;
        if(sysDictType==null){
            page=sysDictTypeRepository.findAll(pageable);
        }else {
            Example<SysDictType> example = Example.of(sysDictType);
            page=sysDictTypeRepository.findAll(example,pageable);
        }
        return page;
    }
}
