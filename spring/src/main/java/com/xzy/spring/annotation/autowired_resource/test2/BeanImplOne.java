package com.xzy.spring.annotation.autowired_resource.test2;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 注解@Order标记定义了组件的加载顺序。
 * 在Spring内部，对基于Spring xml的应用，Spring使用OrderComparator类来实现排序。
 * 对基于注解的应用，Spring采用AnnotationAwareOrderComparator来实现排序。
 */
@Order(1)
@Component
public class BeanImplOne implements BeanInterface {
}
