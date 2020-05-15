package com.wimp.jta.atomikos;

import com.wimp.jta.atomikos.config.DBConfig1;
import com.wimp.jta.atomikos.config.DBConfig2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(value = {DBConfig1.class,DBConfig2.class})
public class JtaAtomikosApplication {

    public static void main(String[] args) {
        SpringApplication.run(JtaAtomikosApplication.class, args);
    }

}
