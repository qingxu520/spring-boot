package co.goho.qingxu.springboot.controller;

import co.goho.qingxu.springboot.pojo.User;
import co.goho.qingxu.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUserByname")
    @Cacheable(value = "userList-byName")
    public List<User> getUserByname(String name){
        List<User> userList = userService.findUserLikeName(name);
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return userList;
    }

    @RequestMapping("/getUserId")
    @Cacheable(value = "userId")
    public String getUser(HttpSession session){
        User user = userService.findByUserName("lt01");
        session.setAttribute("userId",user.getId());
        return session.getId();
    }
}
