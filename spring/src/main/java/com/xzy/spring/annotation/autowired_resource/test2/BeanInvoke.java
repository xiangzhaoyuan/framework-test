package com.xzy.spring.annotation.autowired_resource.test2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 对于@Autowired声明的数组、集合类型把容器中所有类型与集合（数组）中元素类型相同的bean构造出一个对应集合，注入到目标bean中
 */
@Component
public class BeanInvoke {

    @Autowired
    private List<BeanInterface> list;

    @Autowired
    private Map<String, BeanInterface> map;

    public void say() {

        System.out.println("list...");
        if (null != list && 0 != list.size()) {
            for (BeanInterface bean : list) {
                System.out.println(bean.getClass().getName());
            }
        } else {
            System.out.println("List<BeanInterface> list is null!");
        }
        System.out.println();

        System.out.println("map...");
        if (null != map && 0 != map.size()) {
            for (Map.Entry<String, BeanInterface> m : map.entrySet()) {
                System.out.println(m.getKey() + "   " + m.getValue().getClass().getName());
            }
        } else {
            System.out.println("Map<String,BeanInterface> map is null!");
        }
    }
}
