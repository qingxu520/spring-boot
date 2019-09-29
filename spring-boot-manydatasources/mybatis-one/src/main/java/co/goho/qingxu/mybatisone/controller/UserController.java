package co.goho.qingxu.mybatisone.controller;

import co.goho.qingxu.mybatisone.pojo.User;
import co.goho.qingxu.mybatisone.service.UserService;
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

}
