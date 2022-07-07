package com.cashFlowAuditor.Application;

import android.app.Application;

import com.cashFlowAuditor.Models.Business;
import com.cashFlowAuditor.Models.Profession;
import com.cashFlowAuditor.Models.Stock;
import com.cashFlowAuditor.Models.User;

import java.util.concurrent.atomic.AtomicInteger;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmResults;

public class CashFlowApp extends Application {

    public static AtomicInteger ProfessionId = new AtomicInteger();
    public static AtomicInteger StockId = new AtomicInteger();
    public static AtomicInteger UserId = new AtomicInteger();
    public static AtomicInteger BusinessId = new AtomicInteger();

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this.getApplicationContext());
        SetUpRealmConfig();
        Realm realm = Realm.getDefaultInstance();
        ProfessionId = getIdByTable(realm, Profession.class);
        StockId = getIdByTable(realm, Stock.class);
        UserId = getIdByTable(realm, User.class);
        BusinessId = getIdByTable(realm, Business.class);
        realm.close();
    }

    private void SetUpRealmConfig(){
        RealmConfiguration config = new RealmConfiguration
                .Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);
    }

    private <T extends RealmObject> AtomicInteger getIdByTable( Realm realm, Class<T> anyClass){
        RealmResults<T> results = realm.where(anyClass).findAll();
        return (results.size() > 0) ? new AtomicInteger(results.max("id").intValue()): new AtomicInteger();
    }
}
