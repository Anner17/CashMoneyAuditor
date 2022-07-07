package com.cashFlowAuditor.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import io.realm.RealmResults;

/**
 * A simple {@link Fragment} subclass.
 */
public class IncomeFragment extends Fragment {

    private ListAdapter itemAdapter;
    private List<Description> descriptions;
    private RealmResults<Business> businesses;
    private ListView listview;
    private Realm realm;

    public IncomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_income, container, false);
    }

    @Override
    public void onActivityCreated(Bundle state){
        super.onActivityCreated(state);

        realm = Realm.getDefaultInstance();
        Profession profession = realm.where(Profession.class).equalTo("Selected", true).findFirst();
        businesses = realm.where(Business.class).findAll();

        descriptions = new ArrayList<Description>();

        if(profession != null){
            TextView txtProfession = getView().findViewById(R.id.income_profession);
            txtProfession.setText(profession.getDescription());

            descriptions.add(new Description(getString(R.string.salary), profession.getSalary()));

            for(Business business: businesses){
                descriptions.add(new Description(business.getName(), business.getCashFlow()));
            }
        }

        listview = getView().findViewById(R.id.income_list_view);

        itemAdapter = new ListAdapter(getContext(), descriptions, R.layout.listview_description_item);

        listview.setAdapter(itemAdapter);
    }

}
