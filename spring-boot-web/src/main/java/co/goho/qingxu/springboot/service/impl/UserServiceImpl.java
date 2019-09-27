package co.goho.qingxu.springboot.service.impl;

import co.goho.qingxu.springboot.dao.UserRepository;
import co.goho.qingxu.springboot.pojo.User;
import co.goho.qingxu.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findUserLikeName(String name) {
        return userRepository.findByNameLike(name);
    }

    @Override
    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
}
