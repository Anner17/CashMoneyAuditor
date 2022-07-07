package com.cashFlowAuditor.Fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.cashFlowAuditor.Adapter.BusinessAdapter;
import com.cashFlowAuditor.Models.Business;
import com.cashFlowAuditor.Models.Profession;
import com.cashFlowAuditor.Utils.DataLoader;
import com.cashFlowAuditor.R;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmObject;
import io.realm.RealmResults;

public class BusinessFragment extends Fragment {

    private BusinessAdapter businessAdapter;
    private RealmResults<Business> businessList;
    private ListView listViewBusiness;
    private Realm realm;

    public BusinessFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_business, container, false);
    }

    @Override
    public void onActivityCreated(Bundle bundle){
        super.onActivityCreated(bundle);

        realm = Realm.getDefaultInstance();

        Profession profession = realm.where(Profession.class).equalTo("Selected", true).findFirst();
        if (profession != null) {
            TextView txtProfession = getView().findViewById(R.id.business_profession);
            txtProfession.setText(profession.getDescription());
        }
        businessList = realm.where(Business.class).findAll();
        businessAdapter = new BusinessAdapter(getContext(), businessList, R.layout.item_assets);
        businessList.addChangeListener(new RealmChangeListener<RealmResults<Business>>() {
            @Override
            public void onChange(RealmResults<Business> business) {
                businessAdapter.notifyDataSetChanged();
            }
        });

        listViewBusiness = getView().findViewById(R.id.assets_business_list);
        listViewBusiness.setAdapter(businessAdapter);

        Button btnAddBusiness = getView().findViewById(R.id.btn_add_business);
        btnAddBusiness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BtnBusinessClick(getView());
            }
        });
    }

    private void BtnBusinessClick(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
        View viewInflated = LayoutInflater.from(view.getContext()).inflate(R.layout.dialog_create_business, null);
        builder.setView(viewInflated);

        builder.setTitle(getText(R.string.add_business));
        final Spinner spnBusiness = viewInflated.findViewById(R.id.spn_business_name);
        final EditText cashFlowTxt = viewInflated.findViewById(R.id.business_cash_flow);
        final EditText costTxt = viewInflated.findViewById(R.id.business_cost);
        final EditText downPayTxt = viewInflated.findViewById(R.id.business_down_pay);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(viewInflated.getContext(), R.layout.spinner_item, DataLoader.BusinessList());
        adapter.setDropDownViewResource(R.layout.spinner_dropdown);

        spnBusiness.setAdapter(adapter);

        builder.setPositiveButton(getText(R.string.add), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try {
                    Business business = new Business(spnBusiness.getSelectedItem().toString(), Integer.parseInt(downPayTxt.getText().toString()),
                            Integer.parseInt(costTxt.getText().toString()), Integer.parseInt(cashFlowTxt.getText().toString()));
                    Save(business);
                    Toast.makeText(getContext(), getText(R.string.success_item_saved), Toast.LENGTH_SHORT).show();
                }
                catch (Exception ex){
                    Toast.makeText(getContext(), getText(R.string.error_fill_all_fields), Toast.LENGTH_LONG).show();
                }
            }
        }).setNegativeButton(getText(R.string.cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private <T extends RealmObject> void Save(T object) {
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(object);
        realm.commitTransaction();
    }
}
