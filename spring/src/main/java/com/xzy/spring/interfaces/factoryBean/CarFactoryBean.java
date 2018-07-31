package com.xzy.spring.interfaces.factoryBean;

import org.springframework.beans.factory.FactoryBean;

/**
 * 一般情况下，Spring通过反射机制利用<bean>的class属性指定实现类实例化Bean，在某些情况下，实例化Bean过程比较复杂，如果按照传统的方式，
 * 则需要在<bean>中提供大量的配置信息。配置方式的灵活性是受限的，这时采用编码的方式可能会得到一个简单的方案。
 * Spring中就有很多这样的bean，例如：org.springframework.orm.hibernate4.LocalSessionFactoryBean
 * Created by wb-xzy262218 on 2018/6/4.
 */
public class CarFactoryBean implements FactoryBean<Car> {

    private String carInfo;

    public String getCarInfo() {
        return carInfo;
    }

    public void setCarInfo(String carInfo) {
        this.carInfo = carInfo;
    }

    /**
     * 返回由FactoryBean创建的Bean实例
     * 如果isSingleton()返回true，则该实例会放到Spring容器中单实例缓存池中
     */
    @Override
    public Car getObject() throws Exception {
        if (carInfo == null || "".equals(carInfo)) {
            return null;
        }
        String[] infos = carInfo.split(",");
        if (infos.length != 3) {
            return null;
        }
        Car car = new Car();
        car.setBrand(infos[0]);
        car.setMaxSpeed(Integer.valueOf(infos[1]));
        car.setPrice(Double.valueOf(infos[2]));
        return car;
    }

    /**
     * 返回FactoryBean创建的Bean类型
     */
    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    /**
     * 返回由FactoryBean创建的Bean实例的作用域是singleton还是prototype
     */
    @Override
    public boolean isSingleton() {
        return false;
    }
}
