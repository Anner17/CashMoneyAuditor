package com.cashFlowAuditor.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.cashFlowAuditor.Adapter.ListAdapter;
import com.cashFlowAuditor.Models.Description;
import com.cashFlowAuditor.Models.Profession;
import com.cashFlowAuditor.R;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExpensesFragment extends Fragment {

    private ListAdapter itemAdapter;
    private List<Description> descriptions;
    private ListView listview;
    private Realm realm;
    private RealmResults<Profession> professionsList;

    public ExpensesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_expenses, container, false);
    }

    @Override
    public void onActivityCreated(Bundle state){
        super.onActivityCreated(state);

        realm = Realm.getDefaultInstance();
        professionsList = realm.where(Profession.class).findAll();
        professionsList.addChangeListener(new RealmChangeListener<RealmResults<Profession>>() {
            @Override
            public void onChange(RealmResults<Profession> professions) {
                LoadData();
            }
        });

        LoadData();
    }

    public void LoadData(){
        try{
            Profession profession = realm.where(Profession.class).equalTo("Selected", true).findFirst();

            descriptions = new ArrayList<Description>();

            if(profession != null){
                TextView txtProfession = getView().findViewById(R.id.expense_profession);
                txtProfession.setText(profession.getDescription());

                descriptions.add(new Description(getString(R.string.taxes), profession.getTaxes()));
                if (!profession.isHomeMortgagePaid()) {descriptions.add(new Description(getString(R.string.home_mortgage_payment), profession.getHomeMortgagePayment()));}
                if (!profession.isSchoolLoanPaid()) {descriptions.add(new Description(getString(R.string.school_loan_payment), profession.getSchoolLoanPayment()));}
                if (!profession.isCarLoanPaid()) {descriptions.add(new Description(getString(R.string.car_loan_payment), profession.getCarLoanPayment()));}
                if (!profession.isCreditCardPaid()) {descriptions.add(new Description(getString(R.string.credit_card_payment), profession.getCreditCardPayment()));}
                if (!profession.isRetailDebtPaid()) {descriptions.add(new Description(getString(R.string.retail_payment), profession.getRetailPayment()));}
                descriptions.add(new Description(getString(R.string.other_expenses), profession.getOtherExpenses()));
                descriptions.add(new Description(getString(R.string.child_expenses), profession.getPerChildExpense()*profession.getChildNumber()));
                descriptions.add(new Description(getString(R.string.loan_payment), profession.getLoan()/10));
            }

            listview = getView().findViewById(R.id.expenses_list_view);
            itemAdapter = new ListAdapter(getContext(), descriptions, R.layout.listview_description_item);
            listview.setAdapter(itemAdapter);
        }
        catch (Exception e){

        }
    }
}
