package com.xzy.spring.interfaces.applicationListener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * 在一些业务场景中，当容器初始化完成之后，需要处理一些操作，比如一些数据的加载、初始化缓存、特定任务的注册等必须要等到所有的bean都被处理完成之后再进行。这个时候我们就可以使用Spring提供的ApplicationListener来进行操作。
 * ApplicationContext事件机制是观察者设计模式的实现，通过ApplicationEvent类和ApplicationListener接口，可以实现ApplicationContext事件处理。
 * 如果容器中有一个ApplicationListener Bean，每当ApplicationContext发布ApplicationEvent时，ApplicationListener Bean将自动被触发。
 * <p>
 * Spring的事件框架有如下两个重要的成员：
 * ApplicationEvent：容器事件，必须由ApplicationContext发布。
 * ApplicationListener：监听器，可由容器中的任何监听器Bean担任。
 * <p>
 * 当我们往Spring中配置了一个实现了ApplicationListener的Bean，Spring容器就会把这个Bean当成容器事件的监听器。
 * 当系统创建Spring容器、加载Spring容器时会自动触发容器事件，容器事件监听器可以监听到这些事件。除此之外，程序也可以调用ApplicationContext的publishEvent()方法来主动触发一个容器事件。
 */
public class ApplicationStartListener implements ApplicationListener<ContextRefreshedEvent> {

    /**
     * Spring提供如下几个内置事件：
     * ContextRefreshedEvent：ApplicationContext容器初始化或刷新时触发该事件。此处的初始化是指：所有的Bean被成功装载，后处理Bean被检测并激活，所有Singleton Bean被预实例化，ApplicationContext容器已就绪可用。
     * ContextStartedEvent：当使用ConfigurableApplicationContext(ApplicationContext的子接口）接口的start()方法启动ApplicationContext容器时触发该事件。容器管理生命周期的Bean实例将获得一个指定的启动信号，这在经常需要停止后重新启动的场合比较常见。
     * ContextClosedEvent：当使用ConfigurableApplicationContext接口的close()方法关闭ApplicationContext时触发该事件。
     * ContextStoppedEvent：当使用ConfigurableApplicationContext接口的stop()方法使ApplicationContext容器停止时触发该事件。此处的停止，意味着容器管理生命周期的Bean实例将获得一个指定的停止信号，被停止的Spring容器可再次调用start()方法重新启动。
     * RequestHandledEvent：Web相关事件，只能应用于使用DispatcherServlet的Web应用。在使用Spring作为前端的MVC控制器时，当Spring处理用户请求结束后，系统会自动触发该事件。
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        /**
         * 在web项目中（spring mvc），系统会存在两个容器，一个是root application context,另一个就是我们自己的projectName-servlet context（作为root application context的子容器）。
         * 这种情况下，就会造成onApplicationEvent方法被执行两次。为了避免上面提到的问题，我们可以只在root application context初始化完成后调用逻辑代码，其他的容器的初始化完成，则不做任何处理。
         */
        System.out.println("我的父容器为：" + contextRefreshedEvent.getApplicationContext().getParent());
        if (contextRefreshedEvent.getApplicationContext().getParent() != null) {
            return;
        }
        System.out.println("初始化时我被调用了。");
    }
}