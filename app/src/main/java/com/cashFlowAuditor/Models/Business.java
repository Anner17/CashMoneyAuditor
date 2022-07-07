package com.cashFlowAuditor.Models;

import com.cashFlowAuditor.Application.CashFlowApp;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Business extends RealmObject {
    @PrimaryKey
    private int id;
    private String Name;
    private int DownPay;
    private int Cost;
    private int CashFlow;

    public Business(){}

    public Business(String _name, int _downPay, int _cost, int _cashFlow){
        this.id = CashFlowApp.BusinessId.incrementAndGet();
        this.Name = _name;
        DownPay = _downPay;
        Cost = _cost;
        CashFlow = _cashFlow;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getDownPay() {
        return DownPay;
    }

    public void setDownPay(int downPay) {
        DownPay = downPay;
    }

    public int getCost() {
        return Cost;
    }

    public void setCost(int cost) {
        Cost = cost;
    }

    public int getCashFlow() {
        return CashFlow;
    }

    public void setCashFlow(int cashFlow) {
        CashFlow = cashFlow;
    }
}
