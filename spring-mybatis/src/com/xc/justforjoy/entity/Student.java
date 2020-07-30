package com.xc.justforjoy.entity;

/**
 * @author lxcecho
 * @since 2020/7/30
 */
public class Student {

    private Integer id;

    private Integer stuNo;

    private String stuName;

    private Integer stuAge;

    private String graName;

    public int getStuNo() {
        return stuNo;
    }

    public void setStuNo(int stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getStuAge() {
        return stuAge;
    }

    public void setStuAge(int stuAge) {
        this.stuAge = stuAge;
    }

    public String getGraName() {
        return graName;
    }

    public void setGraName(String graName) {
        this.graName = graName;
    }

    @Override
    public String toString() {
        return "学号:" + this.stuNo + "\t姓名:" + this.stuName + "\t年龄:"
                + this.stuAge + "\t年级:" + this.graName;
    }

}
