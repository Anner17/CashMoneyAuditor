package com.cashFlowAuditor.Fragments;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

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

public class LiabilitiesFragment extends Fragment {

    private ListAdapter itemAdapter;
    private ListAdapter itemAdapter2;
    private List<Description> descriptions;
    private List<Description> descriptions2;
    private ListView listview;
    private ListView listview2;
    private Realm realm;
    private Profession profession;
    private RealmResults<Profession> professionList;
    private RealmResults<Business> businesses;

    public LiabilitiesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_liabilities, container, false);
    }

    @Override
    public void onActivityCreated(Bundle state){
        super.onActivityCreated(state);
        realm = Realm.getDefaultInstance();
        professionList = realm.where(Profession.class).findAll();
        professionList.addChangeListener(new RealmChangeListener<RealmResults<Profession>>() {
            @Override
            public void onChange(RealmResults<Profession> professions) {
                LoadData();
            }
        });
        businesses = realm.where(Business.class).findAll();
        businesses.addChangeListener(new RealmChangeListener<RealmResults<Business>>() {
            @Override
            public void onChange(RealmResults<Business> businesses) {
                LoadData();
            }
        });

        LoadData();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, view, menuInfo);
        MenuInflater inflater = getActivity().getMenuInflater();
        inflater.inflate(R.menu.liabilities_menu, menu);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item){
        try{
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

            switch (item.getItemId()){
                case R.id.pay_liabilities_menu:
                    PayLoan(info.position, true);
                    return true;
                case R.id.cancel_liabilities_menu:
                    PayLoan(info.position, false);
                    return true;
                default:
                    return super.onContextItemSelected(item);
            }
        }
        catch (Exception ex){
            Toast.makeText(getContext(),ex.getMessage(),Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private void LoadData(){
        try {
            profession = realm.where(Profession.class).equalTo("Selected", true).findFirst();
            descriptions = new ArrayList<Description>();
            descriptions2 = new ArrayList<Description>();

            if (profession != null) {
                TextView txtProfession = getView().findViewById(R.id.liabilities_profession);
                txtProfession.setText(profession.getDescription());

                descriptions.add(new Description(profession.isHomeMortgagePaid() ? (getString(R.string.home_mortgage) + " : " + getString(R.string.paid)) : getString(R.string.home_mortgage), profession.getHomeMortgage()));
                descriptions.add(new Description(profession.isSchoolLoanPaid() ? (getString(R.string.school_loan) + " : " + getString(R.string.paid)) : getString(R.string.school_loan), profession.getSchoolLoan()));
                descriptions.add(new Description(profession.isCarLoanPaid() ? (getString(R.string.car_loan) + " : " + getString(R.string.paid)) : getString(R.string.car_loan), profession.getCarLoan()));
                descriptions.add(new Description(profession.isCreditCardPaid() ? (getString(R.string.credit_card) + " : " + getString(R.string.paid)) : getString(R.string.credit_card), profession.getCreditCard()));
                descriptions.add(new Description(profession.isRetailDebtPaid() ? (getString(R.string.retail_debt) + " : " + getString(R.string.paid)) : getString(R.string.retail_debt), profession.getRetailDebt()));
            }

            for (Business business : businesses) {
                descriptions2.add(new Description(business.getName(), business.getCost() - business.getDownPay()));
            }

            listview = getView().findViewById(R.id.liabilities_list_view);
            itemAdapter = new ListAdapter(getContext(), descriptions, R.layout.listview_description_item);


            listview2 = getView().findViewById(R.id.liabilities_list_view2);
            itemAdapter2 = new ListAdapter(getContext(), descriptions2, R.layout.listview_description_item);

            listview.setAdapter(itemAdapter);
            listview2.setAdapter(itemAdapter2);

            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                }
            });
            registerForContextMenu(listview);
        }
        catch (Exception e){

        }
    }

    private void PayLoan(int position, boolean value){
        realm.beginTransaction();
        switch (position){
            case 0:
                profession.setHomeMortgagePaid(value);
                break;
            case 1:
                profession.setSchoolLoanPaid(value);
                break;
            case 2:
                profession.setCarLoanPaid(value);
                break;
            case 3:
                profession.setCreditCardPaid(value);
                break;
            case 4:
                profession.setRetailDebtPaid(value);
                break;
            default:
                break;
        }
        realm.copyToRealmOrUpdate(profession);
        realm.commitTransaction();
    }
}
