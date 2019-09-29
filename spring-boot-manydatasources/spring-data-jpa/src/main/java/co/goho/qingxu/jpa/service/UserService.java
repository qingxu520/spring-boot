package co.goho.qingxu.jpa.service;

import co.goho.qingxu.jpa.dao.test.UserRepository;
import co.goho.qingxu.jpa.dao.test1.UserRepository1;
import co.goho.qingxu.jpa.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserRepository userMapper;

    @Autowired
    private UserRepository1 userMapper1;

    public Map<String,List<User>> selectAll(){
        Map map = new HashMap();
        map.put("user",userMapper.findAll());
        map.put("user1",userMapper1.findAll());
        return map;
    }


}
