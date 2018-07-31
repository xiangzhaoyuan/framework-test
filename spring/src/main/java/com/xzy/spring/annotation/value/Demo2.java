package com.xzy.spring.annotation.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 测试@Value("${xxxx}")方式获取配置文件中的值
 */
@Component
public class Demo2 {

    @Value("${db.driverClassName}")
    private String driverClassName;

    @Value("${db.url}")
    private String url;

    @Value("${db.username}")
    private String username;

    @Value("${db.password}")
    private String password;

    @Override
    public String toString() {
        return "Demo2{" + "driverClassName=" + driverClassName + ", url=" + url + ", username=" + username + ", password=" + password + "}";
    }
}
