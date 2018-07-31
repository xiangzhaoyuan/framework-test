package com.xzy.spring.interfaces.pathMatchingResourcePatternResolver;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;

public class TestMain {

    public static void main(String[] args) throws IOException {

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        Resource resource = resolver.getResource("file:pom.xml");
        //Resource resource = resolver.getResource("classpath:interfaces/pathMatchingResourcePatternResolver/application-context.xml");
        System.out.println(resource.getFile().getAbsolutePath());

        /**
         * classpath前缀只能获取当前类路径下的资源文件，而classpath*前缀可以获取所有类路径下的资源文件，包括jar包中的
         * application-*.xml表示匹配以application-开头的所有xml
         * 路径也可以使用*作为通配符，一个*表示一层目录，两个*表示任意多层的目录
         *
         */
        Resource[] resources = resolver.getResources("classpath*:interfaces/**/application-*.xml");
        for (Resource res : resources) {
            System.out.println(res.getFile().getAbsolutePath());
        }

    }

}
