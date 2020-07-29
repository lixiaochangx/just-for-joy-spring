package com.xc.justforjoy.spring.beans.factory;

import com.xc.justforjoy.spring.beans.entity.Car;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lxcecho
 * @since 2020/7/21
 * <p>
 * 静态工厂方法：直接调用某一个静态方法就可以返回Bean的实例
 */
public class StaticFactory {

    private static Map<String, Car> cars = new HashMap<String, Car>(16);

    static {
        cars.put("audi", new Car("Audi", 300000));
        cars.put("ford", new Car("Ford", 500000));
    }

    /**
     * 静态工厂方法
     *
     * @param name
     * @return
     */
    public static Car getCar(String name) {
        return cars.get(name);
    }

}
