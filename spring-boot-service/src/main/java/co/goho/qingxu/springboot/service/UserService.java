package co.goho.qingxu.springboot.service;

import co.goho.qingxu.springboot.pojo.User;

import java.util.Collection;
import java.util.List;

public interface UserService {

    List<User> findUserLikeName(String name);
    User findByUserName(String userName);

    List<User> findAll();
}
