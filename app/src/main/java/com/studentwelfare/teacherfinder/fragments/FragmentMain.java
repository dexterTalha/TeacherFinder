package com.studentwelfare.teacherfinder.fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.studentwelfare.teacherfinder.R;
import com.studentwelfare.teacherfinder.adapters.TabLayoutPagerAdapter;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentMain extends Fragment {


    TabLayout tabLayout1;
    ViewPager viewPager1;

    public FragmentMain() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        viewPager1 = view.findViewById(R.id.viewpager1);
        tabLayout1 = view.findViewById(R.id.tablayout1);
        tabLayout1.setTabGravity(TabLayout.GRAVITY_FILL);


        tabLayout1.addTab(tabLayout1.newTab().setText("All"));
        tabLayout1.addTab(tabLayout1.newTab().setText("Teachers"));
        tabLayout1.addTab(tabLayout1.newTab().setText("Students"));
        tabLayout1.addTab(tabLayout1.newTab().setText("Centers"));
        tabLayout1.addTab(tabLayout1.newTab().setText("Home Tutors"));

        TabLayoutPagerAdapter adapter = new TabLayoutPagerAdapter(Objects.requireNonNull(getActivity()).getSupportFragmentManager(), 5);
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

        viewPager1.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout1));


        return view;
    }

}
