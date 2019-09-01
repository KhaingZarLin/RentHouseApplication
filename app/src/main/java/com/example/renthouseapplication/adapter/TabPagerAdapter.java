package com.example.renthouseapplication.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.renthouseapplication.fragment.TopCollectionFragment;


public class TabPagerAdapter extends FragmentStatePagerAdapter {
    public TabPagerAdapter(FragmentManager fm){super(fm);}
    @Override
    public Fragment getItem(int i) {
        if(i==0)
        {
            return new TopCollectionFragment();
        }
        else if(i==1)
        {
            return new TopCollectionFragment();
        }
        else
        {
            return new TopCollectionFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    public CharSequence getPageTitle(int position)
    {
        if (position==0)
        {
            return "Top Collection";
        }
        else if(position==1)
        {
            return "Near me";
        }
        else
        {
            return "Low to High price";
        }
    }
}
