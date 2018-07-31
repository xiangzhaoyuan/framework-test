package com.xzy.spring.annotation.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 测试@Value("#{configProperties['xxxx']}")方式获取配置文件中的值
 */
@Component
public class Demo1 {

    @Value("#{configProperties['db.driverClassName']}")
    private String driverClassName;

    @Value("#{configProperties['db.url']}")
    private String url;

    @Value("#{configProperties['db.username']}")
    private String username;

    @Value("#{configProperties['db.password']}")
    private String password;

    @Override
    public String toString() {
        return "Demo1{" + "driverClassName=" + driverClassName + ", url=" + url + ", username=" + username + ", password=" + password + "}";
    }
}
