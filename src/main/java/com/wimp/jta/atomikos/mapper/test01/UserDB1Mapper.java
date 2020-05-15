package com.wimp.jta.atomikos.mapper.test01;

import com.wimp.jta.atomikos.bean.User;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;

/**
 * @author zy
 * @date 2020/5/15
 * <p>
 *  
 */
@Mapper
public interface UserDB1Mapper extends BaseMapper<User> {

}
