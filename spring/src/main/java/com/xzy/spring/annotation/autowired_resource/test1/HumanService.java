package com.xzy.spring.annotation.autowired_resource.test1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by wb-xzy262218 on 2018/6/5.
 */
@Service
public class HumanService {


    /*
     * ********************************************************************************************************
     * @Autowired(import org.springframework.beans.factory.annotation.Autowired;)是Spring的注解，
     * 通过AutowiredAnnotationBeanPostProcessor类实现的依赖注入；
     * ********************************************************************************************************
     */

    /*
     * @Autowired是按照byType进行自动装配的，这里Human有两个实现类会报错：NoUniqueBeanDefinitionException
     */
    //@Autowired
    //private Human human;

    /*
     * @Qualifier("XXX")中的XXX是Bean的名称，@Autowired和@Qualifier结合使用时，自动注入的策略就从byType转变成byName
     * 需要注意的是@Autowired可以对成员变量、方法以及构造函数进行注释，而@Qualifier的标注对象是成员变量、方法入参、构造函数入参
     */
    //@Autowired
    //@Qualifier("man")
    //private Human human;

    /*
     * required属性配置为false之后，当没有找到相应bean的时候，系统不会抛错，否则报错：NoSuchBeanDefinitionException
     */
    //@Autowired(required = false)
    //private Dog dog;

    /*
     * Autowired可用于字段上
     */
    //@Autowired
    //private Car car;

    /*
     * Autowired可用于构造方法上
     */
    /*@Autowired
    public HumanService(Car car) {
        this.car = car;
    }*/

    /*
     * Autowired可用于setter方法上
     */
    /*@Autowired
    public void setCar(Car car) {
        this.car = car;
    }*/

    /*
     * @Autowired用在普通方法上也可以注入成功
     */
    /*@Autowired
    public void addCar(Car car){
        this.car = car;
    }*/

    /*
     * ********************************************************************************************************
     * 1、@Resource(import javax.annotation.Resource;)是J2EE的注解,是JSR250规范的实现
     * 2、@Resource有两个重要的属性：name和type，而Spring将@Resource注解的name属性解析为bean的名字，而type属性则解析为bean的类型。
     *   所以，如果使用name属性，则使用byName的自动注入策略，而使用type属性时则使用byType自动注入策略
     * 3、@Resource装配顺序：
     * （1）、如果同时指定了name和type，则从Spring上下文中找到唯一匹配的bean进行装配，找不到则抛出异常。
     * （2）、如果指定了name，则从上下文中查找名称（id）匹配的bean进行装配，找不到则抛出异常。
     * （3）、如果指定了type，则从上下文中找到类似匹配的唯一bean进行装配，找不到或是找到多个，都会抛出异常。
     * （4）、如果既没有指定name，又没有指定type，则自动按照byName方式进行装配；如果没有匹配，则回退为一个原始类型进行匹配，如果匹配则自动装配。
     * 4、@Resource可以作用在变量、setter方法上。
     * ********************************************************************************************************
     */
    @Resource(name = "man")
    private Human human;

    //@Resource(type = com.xzy.spring.annotation.autowired_resource.test1.Benz.class)
    private Car car;

    @Resource
    public void setCar(Car car) {
        this.car = car;
    }

    /*
     * ********************************************************************************************************
     * @Inject是JSR330 (Dependency Injection for Java)中的规范，需要导入javax.inject.Inject;实现注入；
     * @Inject是根据类型进行自动装配的，如果需要按名称进行装配，则需要配合@Named；
     * @Inject可以作用在变量、setter方法、构造函数上。
     * ********************************************************************************************************
     */
    /*@Inject
    @Named("man")
    private Human human;

    private Car car;

    @Inject
    public HumanService(Car car) {
        this.car = car;
    }

    @Inject
    public void setCar(@Named("benz") Car car) {
        this.car = car;
    }*/

    public void showAction() {
        human.speak();
        human.walk();
        car.run();
    }

}
