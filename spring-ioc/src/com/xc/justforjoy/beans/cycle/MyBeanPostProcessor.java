package com.xc.justforjoy.beans.cycle;

import com.xc.justforjoy.beans.entity.Car;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author lxcecho
 * @since 2020/7/21
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessAfterInitialization:"+bean+","+beanName);
		Car car = new Car();
		car.setBrand("ford");
		return car;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessBeforeInitialization:"+bean+","+beanName);
		if("car".equals(beanName)) {
			//......
		}
		return bean;
	}

}
