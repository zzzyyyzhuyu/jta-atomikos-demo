package com.wimp.jta.atomikos.service;

import com.wimp.jta.atomikos.bean.User;
import com.wimp.jta.atomikos.mapper.test01.UserDB1Mapper;
import com.wimp.jta.atomikos.mapper.test02.UserDB2Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author zy
 * @date 2020/5/15
 * <p>
 *  
 */
@Service
public class TestService {

    @Resource
    private UserDB1Mapper userDB1Mapper;
    @Resource
    private UserDB2Mapper userDB2Mapper;

    @Transactional
    public void addDB1User(User user) {
        userDB1Mapper.insert(user);
    }

    @Transactional
    public void addDB2User(User user) {
        userDB2Mapper.insert(user);
        throw new RuntimeException();
    }

    @Transactional
    public void addWithAtomikos(User user) {
        userDB1Mapper.insert(user);
        userDB2Mapper.insert(user);
        throw new RuntimeException();
    }
}
