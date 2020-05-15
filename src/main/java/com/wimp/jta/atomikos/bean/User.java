package com.wimp.jta.atomikos.bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author zy
 * @date 2020/5/15
 * <p>
 *  
 */
@Data
@Table(name = "users")
public class User {
    @Id
    private Integer id;

    @Column(name = "userName")
    private String userName;

    @Column(name = "passWord")
    private String passWord;

    @Column(name = "user_sex")
    private String userSex;

    @Column(name = "nick_name")
    private String nickName;
}

