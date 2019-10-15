package co.goho.qingxu.easy.service.impl;

import co.goho.qingxu.easy.bean.SysDept;
import co.goho.qingxu.easy.dao.SysDeptRepository;
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
public class SysDeptServiceImpl  implements SysDeptService {

    @Autowired
    private SysDeptRepository sysDeptRepository;

    @Override
    public void save(SysDept sysDept) {
        sysDept.inParst();
        sysDeptRepository.save(sysDept);
    }

    @Override
    public void update(SysDept sysDept) {
        sysDept.upParst();
        sysDeptRepository.saveAndFlush(sysDept);
    }

    @Override
    public void deleteById(String id) {
        sysDeptRepository.deleteById(id);
    }

    @Override
    public SysDept findById(String id) {
        Optional<SysDept> optionalT = sysDeptRepository.findById(id);
        return optionalT.isPresent() ? optionalT.get(): null;
    }

    @Override
    public List<SysDept> findList(SysDept sysDept) {
        List<SysDept> deptList = new ArrayList<>();
        Sort sort = new Sort(Sort.Direction.ASC, "orderNum");
        if(sysDept==null){
            deptList=sysDeptRepository.findAll(sort);
        }else {
            Example<SysDept> example = Example.of(sysDept);
            deptList=sysDeptRepository.findAll(example,sort);
        }
        return deptList;
    }

    @Override
    public Page<SysDept> findPage(SysDept sysDept,Pageable pageable) {
        Page<SysDept> page;
        if(sysDept==null){
            page=sysDeptRepository.findAll(pageable);
        }else {
            Example<SysDept> example = Example.of(sysDept);
            page=sysDeptRepository.findAll(example,pageable);
        }
        return page;
    }
}
