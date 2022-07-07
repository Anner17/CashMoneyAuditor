package com.cashFlowAuditor.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;

import com.cashFlowAuditor.Models.Profession;
import com.cashFlowAuditor.R;
import com.cashFlowAuditor.Utils.DataLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfessionFragment extends Fragment {

    private Realm realm = Realm.getDefaultInstance();
    private InterstitialAd interstitialAd;

    public ProfessionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profession, container, false);
    }

    @Override
    public void onActivityCreated(Bundle state){
        super.onActivityCreated(state);
        final Spinner spinProfession = getView().findViewById(R.id.spinProfession);
        final List<Profession> professionList = realm.where(Profession.class).findAll();
        final List<String> professionNames = new ArrayList<String>();

        interstitialAd = new InterstitialAd(getContext());
        interstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        interstitialAd.loadAd(new AdRequest.Builder().build());

        Button btnRandom = getView().findViewById(R.id.btn_random);
        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            int pos = (int)(Math.random()*(professionList.size() - 1)) + 1;
            spinProfession.setSelection(pos);
            }
        });

        Button btnReset = getView().findViewById(R.id.btn_reset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataLoader.ResetData();
                spinProfession.setSelection(0);
            }
        });

        for(Profession pro : professionList){
            professionNames.add(pro.getDescription());
        }

        ArrayAdapter<String> spinAdapter = new ArrayAdapter(getContext(), R.layout.spinner_item, professionNames);
        spinAdapter.setDropDownViewResource(R.layout.spinner_dropdown);
        spinProfession.setAdapter(spinAdapter);

        Profession selected = realm.where(Profession.class).equalTo("Selected", true).findFirst();
        if(selected != null){
            spinProfession.setSelection(spinAdapter.getPosition(selected.getDescription()));
        }

        spinProfession.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getSelectedItem().toString();

                for(Profession profession: professionList){
                    if(profession.getDescription().equals(selectedItem)){
                        updateSelected(profession, true);
                    }
                    else if(profession.isSelected()){
                        updateSelected(profession, false);
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void updateSelected(Profession profession, boolean value){
        realm.beginTransaction();
        profession.setSelected(value);
        realm.commitTransaction();
    }
}
