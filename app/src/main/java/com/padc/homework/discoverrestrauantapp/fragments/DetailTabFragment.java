package com.padc.homework.discoverrestrauantapp.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padc.homework.discoverrestrauantapp.R;
import com.padc.homework.discoverrestrauantapp.delegates.ExploreDetailDetailsTabDelegate;

import butterknife.ButterKnife;

public class DetailTabFragment extends BaseMainFragment {

    private static ExploreDetailDetailsTabDelegate detailsTabDelegate;

    public DetailTabFragment(){}

    @SuppressLint("ValidFragment")
    public DetailTabFragment(ExploreDetailDetailsTabDelegate detailsTabDelegate){
        this.detailsTabDelegate = detailsTabDelegate;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.explore_details_fragment, container, false);
        ButterKnife.bind(this,view);
        detailsTabDelegate.onTabDetailsItem(getActivity(),view);
        return view;
    }
}
