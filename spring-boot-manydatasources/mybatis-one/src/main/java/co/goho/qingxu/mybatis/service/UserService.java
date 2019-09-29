package co.goho.qingxu.mybatis.service;

import co.goho.qingxu.mybatis.mapper.UserMapper;
import co.goho.qingxu.mybatis.mapper1.UserMapper1;
import co.goho.qingxu.mybatis.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserMapper1 userMapper1;

    public Map<String,List<User>> selectAll(){
        Map map = new HashMap();
        map.put("user",userMapper.selectAll());
        map.put("user1",userMapper1.selectAll());
        return map;
    }


}
