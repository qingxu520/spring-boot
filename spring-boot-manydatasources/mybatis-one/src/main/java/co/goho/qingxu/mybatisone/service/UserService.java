package co.goho.qingxu.mybatisone.service;

import co.goho.qingxu.mybatisone.mapper.UserMapper;
import co.goho.qingxu.mybatisone.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> selectAll(){
        return userMapper.selectAll();
    }


}
