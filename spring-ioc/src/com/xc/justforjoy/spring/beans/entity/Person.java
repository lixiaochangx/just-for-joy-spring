package com.xc.justforjoy.spring.beans.entity;

/**
 * @author lxcecho
 * @since 2020/7/21
 */
public class Person {

    private String name;

    private Car car;

    private Address address;

    //引用address bean的city属性
    private String city;

    //根据car的price确定info:car 的price>=300000:金额
    //否则为：白领
    private String info;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", car=" + car +
                ", address=" + address +
                ", city='" + city + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
