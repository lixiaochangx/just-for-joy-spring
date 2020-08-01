package com.xc.justforjoy.factory;

import com.xc.justforjoy.entity.Car;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lxcecho
 * @since 2020/7/21
 * <p>
 * 实例工厂方法：实例工厂的方法，即需要创建工厂本身，再调用工厂的实例方法来返回bean的实例。
 */
public class InstanceFactory {

    private Map<String, Car> cars = null;

    public InstanceFactory() {
        cars = new HashMap<String,Car>(16);
        cars.put("audi", new Car("Audi",300000));
        cars.put("ford", new Car("Ford",500000));
    }

    public Car getCar(String brand) {
        return cars.get(brand);
    }

}
