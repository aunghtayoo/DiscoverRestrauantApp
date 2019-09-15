package com.padc.homework.discoverrestrauantapp.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padc.homework.discoverrestrauantapp.R;
import com.padc.homework.discoverrestrauantapp.adapters.ExploreMenuTabRVAdapter;
import com.padc.homework.discoverrestrauantapp.delegates.ExploreDetailMenuTabDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MenuTabFragment extends BaseMainFragment {

    private ExploreDetailMenuTabDelegate menuTabDelegate;

    public MenuTabFragment(){}

    @SuppressLint("ValidFragment")
    public MenuTabFragment(ExploreDetailMenuTabDelegate menuTabDelegate) {
        this.menuTabDelegate = menuTabDelegate;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.explore_menu_fragment, container, false);
        ButterKnife.bind(this, view);
        menuTabDelegate.onTabMenuItem(getContext(), view);
        return view;
    }

}
