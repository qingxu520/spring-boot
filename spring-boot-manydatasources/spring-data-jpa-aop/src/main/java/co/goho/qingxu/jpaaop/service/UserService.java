package co.goho.qingxu.jpaaop.service;

import co.goho.qingxu.jpaaop.config.datasource.DataSource;
import co.goho.qingxu.jpaaop.config.datasource.DataSourceNames;
import co.goho.qingxu.jpaaop.dao.UserRepository;
import co.goho.qingxu.jpaaop.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserRepository userMapper;

    @DataSource(value= DataSourceNames.FIRST)
    public Map<String,List<User>> selectAll(){
        Map map = new HashMap();
        map.put("user",userMapper.findAll());
        return map;
    }

    @DataSource(value = DataSourceNames.SECOND)
    public Map<String,List<User>> selectAll1(){
        Map map = new HashMap();
        map.put("user1",userMapper.findAll());
        return map;
    }

    public Map<String,List<User>> selectAll2(){
        Map map = new HashMap();
        map.put("user2",userMapper.findAll());
        return map;
    }



}
