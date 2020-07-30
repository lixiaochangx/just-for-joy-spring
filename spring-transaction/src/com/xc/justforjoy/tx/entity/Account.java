package com.xc.justforjoy.tx.entity;

/**
 * @author lxcecho
 * @since 2020/7/30
 */
public class Account {

    private Integer id;

    private String userName;

    private Double balance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Account() {
    }

    public Account(Integer id, String userName, Double balance) {
        this.id = id;
        this.userName = userName;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", balance=" + balance +
                '}';
    }
}
