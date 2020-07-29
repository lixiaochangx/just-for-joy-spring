package com.xc.justforjoy.jdbc.entity;

/**
 * @author lxcecho
 * @since 2020/7/26
 */
public class Employee {

    private Integer id;

    private String lastName;

    private String email;

    private Integer deptId;

    private Department dept;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    public Employee() {
        super();
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Employee(Integer id, String lastName, String email, Integer deptId, Department dept) {
        super();
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.deptId = deptId;
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", deptId=" + deptId +
                ", dept=" + dept +
                '}';
    }
}
