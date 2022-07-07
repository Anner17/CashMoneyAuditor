package com.cashFlowAuditor.Fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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

import com.cashFlowAuditor.Adapter.StockAdapter;
import com.cashFlowAuditor.Models.Profession;
import com.cashFlowAuditor.Models.Stock;
import com.cashFlowAuditor.Utils.DataLoader;
import com.cashFlowAuditor.R;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmObject;
import io.realm.RealmResults;

public class StockFragment extends Fragment {

    private StockAdapter stockAdapter;
    private RealmResults<Stock> stockList;
    private ListView listViewStock;
    private Realm realm;

    public static StockFragment newInstance() {
        return new StockFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_stock, container, false);
    }

    @Override
    public void onActivityCreated( Bundle bundle) {
        super.onActivityCreated(bundle);

        realm = Realm.getDefaultInstance();
        Profession profession = realm.where(Profession.class).equalTo("Selected", true).findFirst();

        if(profession != null) {
            TextView txtProfession = getView().findViewById(R.id.assets_profession);
            txtProfession.setText(profession.getDescription());
        }

        stockList = realm.where(Stock.class).findAll();
        stockAdapter = new StockAdapter(getContext(), stockList, R.layout.item_assets);
        stockList.addChangeListener(new RealmChangeListener<RealmResults<Stock>>() {
            @Override
            public void onChange(RealmResults<Stock> stocks) {
                stockAdapter.notifyDataSetChanged();
            }
        });

        listViewStock = getView().findViewById(R.id.assets_stock_list);
        listViewStock.setAdapter(stockAdapter);

        Button btnAddStock = getView().findViewById(R.id.btn_add_stock);
        btnAddStock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BtnStockClick(getView());
            }
        });
    }

    private void BtnStockClick(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
        View viewInflated = LayoutInflater.from(view.getContext()).inflate(R.layout.dialog_create_stock, null);
        builder.setView(viewInflated);

        builder.setTitle(getText(R.string.add_stock));
        final Spinner spnStock = viewInflated.findViewById(R.id.spn_stock_name);
        final EditText amountTxt = viewInflated.findViewById(R.id.stock_amount);
        final EditText valueTxt = viewInflated.findViewById(R.id.stock_value);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(viewInflated.getContext(), R.layout.spinner_item, DataLoader.StockList());
        adapter.setDropDownViewResource(R.layout.spinner_dropdown);

        spnStock.setAdapter(adapter);

        builder.setPositiveButton(getText(R.string.add), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try {
                    Stock stock = new Stock(spnStock.getSelectedItem().toString(), Integer.parseInt(amountTxt.getText().toString()), Integer.parseInt(valueTxt.getText().toString()));
                    Save(stock);
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
