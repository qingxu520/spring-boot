package co.goho.qingxu.easy.service.impl;

import co.goho.qingxu.easy.bean.SysOperLog;
import co.goho.qingxu.easy.dao.SysOperLogRepository;
import co.goho.qingxu.easy.service.SysOperLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SysOperLogServiceImpl implements SysOperLogService {

    @Autowired
    private SysOperLogRepository sysOperLogRepository;

    @Override
    public void save(SysOperLog sysOperLog) {
        sysOperLog.inParst();
        sysOperLogRepository.save(sysOperLog);
    }

    @Override
    public void update(SysOperLog sysOperLog) {
        sysOperLog.upParst();
        sysOperLogRepository.saveAndFlush(sysOperLog);
    }

    @Override
    public void deleteById(String id) {
        sysOperLogRepository.deleteById(id);
    }

    @Override
    public SysOperLog findById(String id) {
        Optional<SysOperLog> optionalT = sysOperLogRepository.findById(id);
        return optionalT.isPresent() ? optionalT.get(): null;
    }

    @Override
    public List<SysOperLog> findList(SysOperLog sysOperLog) {
        return null;
    }

    @Override
    public Page<SysOperLog> findPage(SysOperLog sysOperLog, Pageable pageable) {
        return null;
    }
}
