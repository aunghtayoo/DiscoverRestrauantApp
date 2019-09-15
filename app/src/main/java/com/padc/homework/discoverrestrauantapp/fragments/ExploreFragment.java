package com.padc.homework.discoverrestrauantapp.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.padc.homework.discoverrestrauantapp.R;
import com.padc.homework.discoverrestrauantapp.data.models.ExploreModel;
import com.padc.homework.discoverrestrauantapp.data.vos.Restaurant;
import com.padc.homework.discoverrestrauantapp.delegates.ExploreDetailMenuTabDelegate;
import com.padc.homework.discoverrestrauantapp.delegates.ExploreItemTabDelegate;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExploreFragment extends BaseMainFragment {

    private static ExploreFragment objInstance;
    private static ExploreItemTabDelegate exploreDelegate;

    public ExploreFragment(){}

    @SuppressLint("ValidFragment")
    public ExploreFragment(ExploreItemTabDelegate exploreDelegate){
        this.exploreDelegate = exploreDelegate;
    }

    public static ExploreFragment getObjInstance(ExploreItemTabDelegate exploreDelegate){
        objInstance = new ExploreFragment(exploreDelegate);
        return objInstance;
    }

    @BindView(R.id.ic_search)
    ImageView icSearch;

    @BindView(R.id.search_input)
    TextInputEditText searchInput;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View views = inflater.inflate(R.layout.explore_fragment, container, false);
        ButterKnife.bind(this, views);
        exploreDelegate.onGetAllRestaurantData(getActivity(), views);

        icSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String keyword = searchInput.getText().toString();
                exploreDelegate.onSearchItems(getActivity(), views, keyword);
            }
        });

        return views;
    }
}
