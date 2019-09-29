package co.goho.qingxu.jpa.service;

import co.goho.qingxu.jpa.dao.UserRepository;
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

    public Map<String,List<User>> selectAll(){
        Map map = new HashMap();
        map.put("user",userMapper.findAll());
        return map;
    }


}
