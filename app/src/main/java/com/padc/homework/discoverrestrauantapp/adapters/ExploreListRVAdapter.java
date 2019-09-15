package com.padc.homework.discoverrestrauantapp.adapters;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padc.homework.discoverrestrauantapp.R;
import com.padc.homework.discoverrestrauantapp.data.vos.Restaurant;
import com.padc.homework.discoverrestrauantapp.delegates.ExploreItemTabDelegate;
import com.padc.homework.discoverrestrauantapp.views.viewholder.ViewHolderExplored;

public class ExploreListRVAdapter extends BaseRecyclerAdapter<ViewHolderExplored, Restaurant> {

    ExploreItemTabDelegate exploreItemTabDelegate;

    public ExploreListRVAdapter(ExploreItemTabDelegate exploreItemTabDelegate){
        this.exploreItemTabDelegate = exploreItemTabDelegate;
    }

    @NonNull
    @Override
    public ViewHolderExplored onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_view_explore, viewGroup, false);
        return new ViewHolderExplored(exploreItemTabDelegate, view);
    }
}
