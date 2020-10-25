package com.wongweiye.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "account")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Account {

    @Id
    @Column(name="accountID")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="amount")
    private int amount;

    public void setName(String name)
    {
        this.name = name;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getName()
    {
        return this.name;
    }

    public int getAmount()
    {
        return this.amount;
    }
}
