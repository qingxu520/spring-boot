package co.goho.qingxu.mybatis.controller;

import co.goho.qingxu.mybatis.pojo.User;
import co.goho.qingxu.mybatis.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/selectAll")
    @ResponseBody
    public Map<String,List<User>> selectAll(){
        logger.info("==========查询成功：总数为"+userService.selectAll().size()+"==========");
        logger.error("==========查询成功：总数为"+userService.selectAll().size()+"==========");
        return userService.selectAll();
    }

}
