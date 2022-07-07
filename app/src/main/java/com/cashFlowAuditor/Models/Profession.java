package com.cashFlowAuditor.Models;

import com.cashFlowAuditor.Application.CashFlowApp;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Profession extends RealmObject {
    @PrimaryKey
    private long id;
    private String Description;
    private int Salary;
    private int Taxes;
    private int HomeMortgagePayment;
    private int SchoolLoanPayment;
    private int CarLoanPayment;
    private int CreditCardPayment;
    private int RetailPayment;
    private int HomeMortgage;
    private boolean HomeMortgagePaid;
    private int SchoolLoan;
    private boolean SchoolLoanPaid;
    private int CarLoan;
    private boolean CarLoanPaid;
    private int CreditCard;
    private boolean CreditCardPaid;
    private int RetailDebt;
    private boolean RetailDebtPaid;
    private int PerChildExpense;
    private int ChildNumber;
    private int OtherExpenses;
    private int Savings;
    private boolean Selected;
    private int Loan;

    public Profession(){}

    public Profession(String Description, int Salary, int Taxes, int HomeMortgagePayment, int SchoolLoanPayment,int CarLoanPayment,
                      int CreditCardPayment, int RetailPayment, int OtherExpenses, int HomeMortgage, int SchoolLoan, int CarLoan,
                      int CreditCard, int RetailDebt, int PerChildExpense, int ChildNumber,  int Savings, int loan){
        this.Description = Description;
        this.Salary = Salary;
        this.Taxes = Taxes;
        this.HomeMortgage = HomeMortgage;
        this.HomeMortgagePayment = HomeMortgagePayment;
        this.SchoolLoan = SchoolLoan;
        this.SchoolLoanPayment = SchoolLoanPayment;
        this.CarLoan = CarLoan;
        this.CarLoanPayment = CarLoanPayment;
        this.CreditCard = CreditCard;
        this.CreditCardPayment = CreditCardPayment;
        this.RetailDebt = RetailDebt;
        this.RetailPayment = RetailPayment;
        this.PerChildExpense = PerChildExpense;
        this.ChildNumber = ChildNumber;
        this.OtherExpenses = OtherExpenses;
        this.Savings = Savings;
        this.id = CashFlowApp.ProfessionId.incrementAndGet();
        this.Loan = loan;
        this.CarLoanPaid = false;
        this.CreditCardPaid = false;
        this.HomeMortgagePaid = false;
        this.RetailDebtPaid = false;
        this.SchoolLoanPaid = false;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return Description;
    }

    public int getSalary() {
        return Salary;
    }

    public int getTaxes() {
        return Taxes;
    }

    public int getHomeMortgagePayment() {
        return HomeMortgagePayment;
    }

    public int getSchoolLoanPayment() {
        return SchoolLoanPayment;
    }

    public int getCarLoanPayment() {
        return CarLoanPayment;
    }

    public int getCreditCardPayment() {
        return CreditCardPayment;
    }

    public int getRetailPayment() {
        return RetailPayment;
    }

    public int getHomeMortgage() {
        return HomeMortgage;
    }

    public int getSchoolLoan() {
        return SchoolLoan;
    }

    public int getCarLoan() {
        return CarLoan;
    }

    public int getCreditCard() {
        return CreditCard;
    }

    public int getRetailDebt() {
        return RetailDebt;
    }

    public int getPerChildExpense() {
        return PerChildExpense;
    }

    public int getChildNumber() {
        return ChildNumber;
    }

    public void setChildNumber(int childNumber) {
        ChildNumber = childNumber;
    }

    public int getOtherExpenses() {
        return OtherExpenses;
    }

    public int getSavings() {
        return Savings;
    }

    public boolean isSelected() {
        return Selected;
    }

    public void setSelected(boolean selected) {
        Selected = selected;
    }

    public int getLoan() {
        return Loan;
    }

    public void setLoan(int loan) {
        Loan = loan;
    }

    public boolean isHomeMortgagePaid() {
        return HomeMortgagePaid;
    }

    public void setHomeMortgagePaid(boolean homeMortgagePaid) {
        HomeMortgagePaid = homeMortgagePaid;
    }

    public boolean isSchoolLoanPaid() {
        return SchoolLoanPaid;
    }

    public void setSchoolLoanPaid(boolean schoolLoanPaid) {
        SchoolLoanPaid = schoolLoanPaid;
    }

    public boolean isCarLoanPaid() {
        return CarLoanPaid;
    }

    public void setCarLoanPaid(boolean carLoanPaid) {
        CarLoanPaid = carLoanPaid;
    }

    public boolean isCreditCardPaid() {
        return CreditCardPaid;
    }

    public void setCreditCardPaid(boolean creditCardPaid) {
        CreditCardPaid = creditCardPaid;
    }

    public boolean isRetailDebtPaid() {
        return RetailDebtPaid;
    }

    public void setRetailDebtPaid(boolean retailDebtPaid) {
        RetailDebtPaid = retailDebtPaid;
    }
}
