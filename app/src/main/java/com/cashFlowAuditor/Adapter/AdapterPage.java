package com.cashFlowAuditor.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.cashFlowAuditor.Fragments.ProfessionFragment;
import com.cashFlowAuditor.Fragments.BusinessFragment;
import com.cashFlowAuditor.Fragments.ExpensesFragment;
import com.cashFlowAuditor.Fragments.IncomeFragment;
import com.cashFlowAuditor.Fragments.LiabilitiesFragment;
import com.cashFlowAuditor.Fragments.ResumeFragment;
import com.cashFlowAuditor.Fragments.StockFragment;

public class AdapterPage extends FragmentStatePagerAdapter {

    private int numTabs;

    public AdapterPage(@NonNull FragmentManager fm, int numTabs) {
        super(fm, numTabs);
        this.numTabs = numTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new ProfessionFragment();
            case 1:
                return new ResumeFragment();
            case 2:
                return new IncomeFragment();
            case 3:
                return new ExpensesFragment();
            case 4:
                return new LiabilitiesFragment();
            case 5:
                return new BusinessFragment();
            case 6:
                return new StockFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numTabs;
    }
}
