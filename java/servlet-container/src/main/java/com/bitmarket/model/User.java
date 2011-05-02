package com.bitmarket.model;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Embeddable
public class User extends Identifiable{
    private String name;
    private BigDecimal balance;
    private Date registrationDate;

    /**
     * Number of transactions this user successfully complete
     */
    private int completedTx;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public int getCompletedTx() {
        return completedTx;
    }

    public void setCompletedTx(int completedTx) {
        this.completedTx = completedTx;
    }
}

