package com.studentwelfare.teacherfinder;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabReselectListener;
import com.studentwelfare.teacherfinder.adapters.TabLayoutPagerAdapter;
import com.studentwelfare.teacherfinder.fragments.ChatFragment;
import com.studentwelfare.teacherfinder.fragments.FragmentMain;
import com.studentwelfare.teacherfinder.fragments.ProfileFragment;


public class HomePage extends AppCompatActivity{

    ViewPager viewPager1;
    TabLayout tabLayout1;
    Toolbar toolbar;
    BottomNavigationView bottomBar;
    FragmentManager fragmentManager;
    CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        toolbar = findViewById(R.id.toolbar_home);
        setSupportActionBar(toolbar);

        bottomBar = findViewById(R.id.bottomBar);
        cardView = findViewById(R.id.card_home);

        /*viewPager1 = findViewById(R.id.viewpager1);
        tabLayout1 = findViewById(R.id.tablayout1);
        toolbar = findViewById(R.id.toolbar_home);
        setSupportActionBar(toolbar);
        //setCustomFontAndStyle(tabLayout1, 0);
        tabLayout1.setTabGravity(TabLayout.GRAVITY_FILL);


        tabLayout1.addTab(tabLayout1.newTab().setText("All"));
        tabLayout1.addTab(tabLayout1.newTab().setText("Teachers"));
        tabLayout1.addTab(tabLayout1.newTab().setText("Students"));
        tabLayout1.addTab(tabLayout1.newTab().setText("Centers"));
        tabLayout1.addTab(tabLayout1.newTab().setText("Home Tutors"));

        TabLayoutPagerAdapter adapter = new TabLayoutPagerAdapter(getSupportFragmentManager(), 5);
        viewPager1.setAdapter(adapter);

        tabLayout1.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager1.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager1.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout1));*/
        //tabLayout1.setupWithViewPager(viewPager1);

        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frag_main, new FragmentMain()).commit();

        bottomBar.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            fragmentManager = getSupportFragmentManager();
            int id = item.getItemId();
            switch (id) {
                case R.id.tab_home1:
                    cardView.setVisibility(View.VISIBLE);
                    fragmentManager.beginTransaction().replace(R.id.frag_main, new FragmentMain()).commit();
                    return true;
                case R.id.tab_message1:
                    //fragmentManager = getSupportFragmentManager();
                    cardView.setVisibility(View.GONE);
                    fragmentManager.beginTransaction().replace(R.id.frag_main, new ChatFragment()).commit();
                    return true;
                case R.id.tab_profile1:
                    cardView.setVisibility(View.GONE);
                    //fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.frag_main, new ProfileFragment()).commit();
                    return true;

            }
            return false;
        }
    };
}
