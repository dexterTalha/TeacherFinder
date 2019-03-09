package com.studentwelfare.teacherfinder.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.studentwelfare.teacherfinder.fragments.AllFragment;
import com.studentwelfare.teacherfinder.fragments.CoachingFragments;
import com.studentwelfare.teacherfinder.fragments.HomeTutions;
import com.studentwelfare.teacherfinder.fragments.StudentsFragment;
import com.studentwelfare.teacherfinder.fragments.TeachersFragment;

public class TabLayoutPagerAdapter extends FragmentStatePagerAdapter {

    private int tabCounts;
    public TabLayoutPagerAdapter(FragmentManager fm, int noOfTabs) {
        super(fm);
        this.tabCounts = noOfTabs;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0:
                return new AllFragment();
            case 1:
                return new TeachersFragment();
            case 2:
                return new StudentsFragment();
            case 3:
                return new CoachingFragments();
            case 4:
                return new HomeTutions();
            default:
                return null;


        }

    }

    @Override
    public int getCount() {
        return tabCounts;
    }
}
