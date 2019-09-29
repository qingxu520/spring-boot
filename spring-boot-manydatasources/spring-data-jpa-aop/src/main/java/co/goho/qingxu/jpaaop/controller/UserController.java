package co.goho.qingxu.jpaaop.controller;

import co.goho.qingxu.jpaaop.pojo.User;
import co.goho.qingxu.jpaaop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/selectAll")
    @ResponseBody
    public Map<String,List<User>> selectAll(){
        return userService.selectAll();
    }
    @RequestMapping("/selectAll1")
    @ResponseBody
    public Map<String,List<User>> selectAll1(){
        return userService.selectAll1();
    }

    @RequestMapping("/selectAll2")
    @ResponseBody
    public Map<String,List<User>> selectAll2(){
        return userService.selectAll2();
    }

}
