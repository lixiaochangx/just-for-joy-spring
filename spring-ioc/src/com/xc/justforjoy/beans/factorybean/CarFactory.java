package com.xc.justforjoy.beans.factorybean;

import com.xc.justforjoy.beans.entity.Car;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author lxcecho
 * @since 2020/7/21
 * <p>
 * 自定义的FactoryBean需要实现FactoryBean接口
 */
public class CarFactory implements FactoryBean {

    private String brand;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * 返回bean的对象实例
     *
     * @return
     * @throws Exception
     */
    @Override
    public Object getObject() throws Exception {
        return new Car("劳斯莱斯",50000000.0);
    }

    /**
     * 返回bean的类型
     *
     * @return
     */
    @Override
    public Class<?> getObjectType() {
        // 返回的是FactoryBean的getObject()方法返回的实例
        return Car.class;
    }

    /**
     * 返回的bean是否为单例
     *
     * @return
     */
    @Override
    public boolean isSingleton() {
        return true;
    }

}
