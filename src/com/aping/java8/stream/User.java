package com.aping.java8.stream;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Aping
 * @since 2022/9/14 16:57
 */
public class User implements Serializable {

    private Long id;

    private String name;

    private Integer age;

    private BigDecimal balance;

    private AccountInfo accountInfo;

    public User(Long id, String name, Integer age, BigDecimal balance) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public AccountInfo getAccountInfo() {
        return accountInfo;
    }

    public void setAccountInfo(AccountInfo accountInfo) {
        this.accountInfo = accountInfo;
    }

    public static class AccountInfo implements Serializable {

        private String accountNo;

        private String accountName;

        public String getAccountNo() {
            return accountNo;
        }

        public void setAccountNo(String accountNo) {
            this.accountNo = accountNo;
        }

        public String getAccountName() {
            return accountName;
        }

        public void setAccountName(String accountName) {
            this.accountName = accountName;
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", balance=" + balance +
                ", accountInfo=" + accountInfo +
                '}';
    }
}
