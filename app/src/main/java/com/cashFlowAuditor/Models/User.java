package com.cashFlowAuditor.Models;

import com.cashFlowAuditor.Application.CashFlowApp;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class User extends RealmObject {
    @PrimaryKey
    public int id;
    public Profession profession;
    public RealmList<Business> businesses;

    public User(){}

    public User(Profession profession){
        this.profession = profession;
        this.businesses = new RealmList<Business>();
        this.id = CashFlowApp.UserId.incrementAndGet();
    }

    public int getId() {
        return id;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public RealmList<Business> getBusinesses() {
        return businesses;
    }

    public void setBusinesses(RealmList<Business> businesses) {
        this.businesses = businesses;
    }
}
