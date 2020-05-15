package com.wimp.jta.atomikos.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author zy
 * @date 2020/5/14
 * <p>
 *  
 */
@Data
@ConfigurationProperties(prefix = "mysql.datasource.test1")
public class DBConfig1 {
    private String url;
    private String username;
    private String password;
    private int minPoolSize;
    private int maxPoolSize;
    private int maxLifetime;
    private int borrowConnectionTimeout;
    private int loginTimeout;
    private int maintenanceInterval;
    private int maxIdleTime;
    private String testQuery;
}
