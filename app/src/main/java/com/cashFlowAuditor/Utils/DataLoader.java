package com.cashFlowAuditor.Utils;

import com.cashFlowAuditor.Models.Business;
import com.cashFlowAuditor.Models.Profession;
import com.cashFlowAuditor.Models.Stock;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class DataLoader {

    private static Realm realm = Realm.getDefaultInstance();
    private static List<Profession> professions;

    public DataLoader(){
        professions = new ArrayList<Profession>();
        professions.add(new Profession("Select", 0, 0, 0, 0,0,0,0,0, 0,0,0,0,0,0,0,0,0));
        professions.add(new Profession("Teacher", 3300, 630, 500, 60,100,90,50,760, 50000,12000,5000,3000,1000,180,0,400,0));
        professions.add(new Profession("Truck Driver", 2500, 460, 400, 0,80,60,50,570, 38000,0,4000,2000,1000,140,0,400,0));
        professions.add(new Profession("Janitor", 1600, 280, 200, 0,60,60,50,300, 20000,0,4000,2000,1000,70,0,560,0));
        professions.add(new Profession("Police Officer", 3000, 580, 400, 0,100,60,50,690, 46000,0,5000,2000,1000,160,0,520,0));
        professions.add(new Profession("Secretary", 2500, 460, 400, 0,80,60,50,570, 38000,0,4000,2000, 1000,140,0,710,0));
        professions.add(new Profession("Nurse", 3100, 600, 400, 30,100,90,50,710, 47000,6000,5000,3000,1000,170,0,480,0));
        professions.add(new Profession("Teacher", 3300, 630, 500, 60,100,90,50,760, 50000,12000,5000,3000,1000,180,0,400,0));
        professions.add(new Profession("Airline Pilot", 9500, 2350, 1330, 0,300,650,50,2210, 143000,0,15000,22000,1000,480,0,400,0));
        professions.add(new Profession("Lawyer", 7500, 1830, 1100, 390,220,180,50,1650, 115000,78000,11000,6000,1000,380,0,400,0));
        professions.add(new Profession("Engineer", 4900, 1050, 700, 60,140,120,50,1090, 75000,12000,7000,4000,1000,250,0,400,0));
        professions.add(new Profession("Mechanic", 2000, 360, 300, 0,60,60,50,450, 31000,0,3000,2000,1000,110,0,670,0));
        professions.add(new Profession("Business Manager", 4600, 910,700, 60,120,90,50,1000, 75000,12000,6000,3000,1000,240,0,400,0));
        professions.add(new Profession("Doctor", 13200, 3420, 1900, 750,380,270,50,2880, 202000,150000,19000,9000,1000,640,0,400,0));
    }

    public static void InitData(){
        //DeleteAll();
        for (Profession profession: professions) {
            Profession temp = realm.where(Profession.class).equalTo("Description", profession.getDescription()).findFirst();
            if(temp == null){
                realm.beginTransaction();
                realm.copyToRealmOrUpdate(profession);
                realm.commitTransaction();
            }
        }
    }

    public static void ResetData(){
        for (Profession profession: professions) {
            Profession temp = realm.where(Profession.class).equalTo("Description", profession.getDescription()).findFirst();
            realm.beginTransaction();
            temp.setRetailDebtPaid(profession.isRetailDebtPaid());
            temp.setCreditCardPaid(profession.isCreditCardPaid());
            temp.setCarLoanPaid(profession.isCarLoanPaid());
            temp.setSchoolLoanPaid(profession.isSchoolLoanPaid());
            temp.setHomeMortgagePaid(profession.isHomeMortgagePaid());
            temp.setChildNumber(profession.getChildNumber());
            temp.setLoan(profession.getLoan());
            temp.setSelected(profession.isSelected());
            realm.commitTransaction();
        }

        realm.beginTransaction();
        realm.delete(Business.class);
        realm.delete((Stock.class));
        realm.commitTransaction();
    }

    public static List<String> StockList(){
        List<String> stockList = new ArrayList<String>();
        stockList.add( "OK4U");
        stockList.add("MYT4U");
        stockList.add("ON2U");
        stockList.add("GRO4US");
        stockList.add("Gold Money");

        return stockList;
    }

    public static List<String> BusinessList(){
        List<String> businessList = new ArrayList<String>();
        businessList.add("duplex");
        businessList.add("4-plex");
        businessList.add("8-plex");
        businessList.add("20 Acres");
        businessList.add("Apartment House(12 unit)");
        businessList.add("Apartment House(24 unit)");
        businessList.add("Apartment Complex(60 unit)");
        businessList.add("Automated Business");
        businessList.add("Bed and Breakfast");
        businessList.add("BIG POWER");
        businessList.add("Car Wash");
        businessList.add("Certificate of Deposit");
        businessList.add("Company Part Time");
        businessList.add("Condo 2Br/1Ba");
        businessList.add("House 3Br/2Ba");
        businessList.add("Limited Partner Wanted");
        businessList.add("Pizza Franchise");
        businessList.add("Other Expenses");

        return businessList;
    }

    private static void DeleteAll(){
        realm.beginTransaction();
        realm.deleteAll();
        realm.commitTransaction();
    }
}
