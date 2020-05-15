package com.wimp.jta.atomikos.controller;

import com.wimp.jta.atomikos.service.TestService;
import com.wimp.jta.atomikos.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zy
 * @date 2020/5/15
 * <p>
 *  
 */
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/addDB1")
    public User addDB1(){
        User user = new User();
        user.setNickName("zzzDB1");
        user.setPassWord("123456");
        testService.addDB1User(user);
        return user;
    }

    @GetMapping("addDB2")
    public User addDB2(){
        User user = new User();
        user.setNickName("zzzDB2");
        user.setPassWord("123456");
        testService.addDB2User(user);
        return user;
    }

    @GetMapping("/addWithAtomikos")
    public String addWithAtomikos(){
        User user = new User();
        user.setNickName("zzzAtomikos");
        user.setPassWord("123456");
        testService.addWithAtomikos(user);
        return "OK";
    }


}
