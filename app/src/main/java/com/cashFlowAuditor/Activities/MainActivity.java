package com.cashFlowAuditor.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;

import com.cashFlowAuditor.Utils.DataLoader;
import com.cashFlowAuditor.Adapter.AdapterPage;
import com.cashFlowAuditor.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.tabs.TabLayout;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private InterstitialAd interstitialAd;
    private long timerAd = 1000 * 60 * 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize ads
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });
        interstitialAd = new InterstitialAd(this);
        //interstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");//test
        interstitialAd.setAdUnitId("ca-app-pub-4887021520549284/2288276553");//Production

        TimerAds();

        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        final TabLayout tabLayout = findViewById((R.id.tabLayout));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_profession));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_resume));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_income));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_expenses));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_liabilities));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.business));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.stocks));

        DataLoader dataLoader = new DataLoader();
        dataLoader.InitData();
        viewPager = findViewById((R.id.viewPager));
        final PagerAdapter adapter = new AdapterPage(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                TabLayout.Tab tab = tabLayout.getTabAt(position);
                tab.select();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onResume(){
        super.onResume();
        if(viewPager != null && viewPager.getAdapter() != null) {
            viewPager.getAdapter().notifyDataSetChanged();
        }
    }

    private void TimerAds(){
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        interstitialAd.loadAd(new AdRequest.Builder().build());
                        if (interstitialAd.isLoaded()) {
                            interstitialAd.show();
                        }
                    }
                });
            }
        };

        timer.schedule(task, timerAd, timerAd);
    }
}
