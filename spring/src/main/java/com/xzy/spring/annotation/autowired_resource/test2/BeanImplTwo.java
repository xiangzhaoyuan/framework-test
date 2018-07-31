package com.xzy.spring.annotation.autowired_resource.test2;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Component
public class BeanImplTwo implements BeanInterface {
}
