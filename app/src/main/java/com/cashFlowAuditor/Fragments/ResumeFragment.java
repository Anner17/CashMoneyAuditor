package com.cashFlowAuditor.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.cashFlowAuditor.Adapter.ListAdapter;
import com.cashFlowAuditor.Models.Business;
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
public class ResumeFragment extends Fragment {

    private ListAdapter itemAdapter;
    private List<Description> descriptions;
    private RealmResults<Business> businesses;
    private ListView listview;
    private Realm realm;
    private Profession profession;
    private RealmResults<Profession> professionList;

    public ResumeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_resume, container, false);
    }

    @Override
    public void onActivityCreated(Bundle state){
        super.onActivityCreated(state);
        realm = Realm.getDefaultInstance();
        profession = realm.where(Profession.class).equalTo("Selected", true).findFirst();
        professionList = realm.where(Profession.class).findAll();
        professionList.addChangeListener(new RealmChangeListener<RealmResults<Profession>>() {
            @Override
            public void onChange(RealmResults<Profession> professions) {
                for(Profession pro : professions){
                    if(pro.isSelected()){
                        profession = pro;
                        FullLoad();
                    }
                }
            }
        });

        if(profession != null && getView() != null) {
            FullLoad();
        }
    }

    private void FullLoad(){
        try {
            InitComponents(getView());
            SetData(getView());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void InitComponents(View _view){
        final View view = _view;
        businesses = realm.where(Business.class).findAll();
        final TextView loanValue = view.findViewById(R.id.loan_value);
        loanValue.setText(Integer.toString(profession.getLoan()));
        final TextView childCount = view.findViewById(R.id.child_count);
        childCount.setText(Integer.toString(profession.getChildNumber()));

        Button addCredit = view.findViewById(R.id.sum_debt);
        addCredit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realm.beginTransaction();
                profession.setLoan(profession.getLoan() + 1000);
                realm.commitTransaction();
                loanValue.setText(Integer.toString(profession.getLoan()));
                SetData(view);
            }
        });

        Button restCredit = view.findViewById(R.id.rest_debt);
        restCredit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (profession.getLoan() > 0) {
                    realm.beginTransaction();
                    profession.setLoan(profession.getLoan() - 1000);
                    realm.commitTransaction();
                    loanValue.setText(Integer.toString(profession.getLoan()));
                    SetData(view);
                }
            }
        });

        Button addChild = view.findViewById(R.id.sum_child);
        addChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (profession.getChildNumber() < 3) {
                    realm.beginTransaction();
                    profession.setChildNumber(profession.getChildNumber() + 1);
                    realm.commitTransaction();
                    childCount.setText(Integer.toString(profession.getChildNumber()));
                    SetData(view);
                }
            }
        });

        Button restChild = view.findViewById(R.id.rest_child);
        restChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (profession.getChildNumber() > 0) {
                    realm.beginTransaction();
                    profession.setChildNumber(profession.getChildNumber() - 1);
                    realm.commitTransaction();
                    childCount.setText(Integer.toString(profession.getChildNumber()));
                    SetData(view);
                }
            }
        });
    }

    private void SetData(View view){
        descriptions = new ArrayList<Description>();
        if(profession != null){
            TextView txtProfession = view.findViewById(R.id.resume_profession);
            txtProfession.setText(profession.getDescription());

            int totalExpenses = profession.getTaxes() +
                    (profession.isHomeMortgagePaid() ? 0 : profession.getHomeMortgagePayment()) +
                    (profession.isSchoolLoanPaid() ? 0 : profession.getSchoolLoanPayment()) +
                    (profession.isCarLoanPaid() ? 0 : profession.getCarLoanPayment()) +
                    (profession.isCreditCardPaid() ? 0 : profession.getCreditCardPayment()) +
                    (profession.isRetailDebtPaid() ? 0 : profession.getRetailPayment()) +
                    profession.getOtherExpenses() +
                    (profession.getPerChildExpense()*profession.getChildNumber()) +
                    profession.getLoan()/10;

            int totalPasiveIncome = 0;
            for(Business business: businesses){
                totalPasiveIncome += business.getCashFlow();
            }

            TextView advanceVal = view.findViewById(R.id.advance_value);
            double advance = ((double) totalPasiveIncome/(double) totalExpenses)*100;
            advanceVal.setText( String.format("%.2f", advance)+"%");

            descriptions.add(new Description(getString(R.string.tab_expenses), totalExpenses));
            descriptions.add(new Description(getString(R.string.passive_income), totalPasiveIncome));
            descriptions.add(new Description(getString(R.string.total_income), totalPasiveIncome + profession.getSalary()));
            descriptions.add(new Description(getString(R.string.cash_flow), totalPasiveIncome + profession.getSalary() - totalExpenses, true));
            descriptions.add(new Description(getString(R.string.per_child_expense), profession.getPerChildExpense()));

            listview = view.findViewById(R.id.resume_list);
            itemAdapter = new ListAdapter(getContext(), descriptions, R.layout.listview_description_item);
            listview.setAdapter(itemAdapter);
        }
    }
}
