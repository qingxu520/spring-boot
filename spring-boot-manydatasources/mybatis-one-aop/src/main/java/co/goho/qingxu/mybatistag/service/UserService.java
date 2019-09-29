package co.goho.qingxu.mybatistag.service;

import co.goho.qingxu.mybatistag.config.datasource.DataSource;
import co.goho.qingxu.mybatistag.config.datasource.DataSourceNames;
import co.goho.qingxu.mybatistag.mapper.UserMapper;
import co.goho.qingxu.mybatistag.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @DataSource(value=DataSourceNames.FIRST)
    public Map<String,List<User>> selectAll(){
        Map map = new HashMap();
        map.put("user",userMapper.selectAll());
        return map;
    }

    @DataSource(value = DataSourceNames.SECOND)
    public Map<String,List<User>> selectAll1(){
        Map map = new HashMap();
        map.put("user1",userMapper.selectAll());
        return map;
    }

    public Map<String,List<User>> selectAll2(){
        Map map = new HashMap();
        map.put("user2",userMapper.selectAll());
        return map;
    }

}
