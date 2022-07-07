package com.cashFlowAuditor.Models;

import com.cashFlowAuditor.Application.CashFlowApp;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Stock extends RealmObject {
    @PrimaryKey
    private long id;
    @Required
    private String Name;

    private int Amount;

    private int Value;

    public Stock(){}

    public Stock(String name, int amount, int value){
        this.Name = name;
        this.Amount = amount;
        this.Value = value;
        this.id = CashFlowApp.StockId.incrementAndGet();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public int getValue() {
        return Value;
    }

    public void setValue(int value) {
        Value = value;
    }
}
