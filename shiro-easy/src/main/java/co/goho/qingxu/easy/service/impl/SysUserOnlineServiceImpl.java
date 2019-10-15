package co.goho.qingxu.easy.service.impl;

import co.goho.qingxu.easy.bean.SysUserOnline;
import co.goho.qingxu.easy.dao.SysUserOnlineRepository;
import co.goho.qingxu.easy.service.SysUserOnlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SysUserOnlineServiceImpl implements SysUserOnlineService {

    @Autowired
    private SysUserOnlineRepository sysUserOnlineRepository;


    @Override
    public List<SysUserOnline> findByLastAccessTimeGreaterThan(Date lastAccessTime) {
        return sysUserOnlineRepository.findByLastAccessTimeGreaterThan(lastAccessTime);
    }

    @Override
    public void batchDeleteOnline(List<SysUserOnline> sessions) {
        sysUserOnlineRepository.deleteAll(sessions);
    }

    @Override
    public void deleteById(String id) {
        sysUserOnlineRepository.deleteById(id);
    }

    @Override
    public SysUserOnline findById(String id) {
        Optional<SysUserOnline> optionalT = sysUserOnlineRepository.findById(id);
        return optionalT.isPresent() ? optionalT.get(): null;
    }

    @Override
    public void save(SysUserOnline sysUserOnline) {
        sysUserOnline.inParst();
        sysUserOnlineRepository.save(sysUserOnline);
    }
}
