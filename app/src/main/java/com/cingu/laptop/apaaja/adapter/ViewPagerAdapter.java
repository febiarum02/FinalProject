package com.cingu.laptop.apaaja.adapter;

import com.cingu.laptop.apaaja.fragment.OrderFragment;
import com.cingu.laptop.apaaja.fragment.HomeFragment;
import com.cingu.laptop.apaaja.fragment.UserFragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {


    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 1:
                return new UserFragment();
            case 2:
                return new OrderFragment();
            default:
                return new HomeFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }


}
