package com.padc.homework.discoverrestrauantapp.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.padc.homework.discoverrestrauantapp.delegates.ExploreDetailDetailsTabDelegate;
import com.padc.homework.discoverrestrauantapp.delegates.ExploreDetailMenuTabDelegate;
import com.padc.homework.discoverrestrauantapp.fragments.DetailTabFragment;
import com.padc.homework.discoverrestrauantapp.fragments.MenuTabFragment;

public class DetailTabVPAdapter extends FragmentStatePagerAdapter {

    private static ExploreDetailMenuTabDelegate menuTabDelegate;
    private static ExploreDetailDetailsTabDelegate detailsTabDelegate;

    public DetailTabVPAdapter(FragmentManager fm, ExploreDetailMenuTabDelegate menuTabDelegate,
                              ExploreDetailDetailsTabDelegate detailsTabDelegate) {
        super(fm);
        this.menuTabDelegate = menuTabDelegate;
        this.detailsTabDelegate = detailsTabDelegate;
    }

    @Override
    public Fragment getItem(int item) {
        switch (item){
            case 0 : return new DetailTabFragment(detailsTabDelegate);
            case 1 : return new MenuTabFragment(menuTabDelegate);
            case 2 : return new DetailTabFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0 : return "DETAILS";
            case 1 : return "MENU";
            case 2 : return "REVIEWS";
        }
        return null;
    }
}
