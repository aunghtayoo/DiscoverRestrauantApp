package com.padc.homework.discoverrestrauantapp.adapters;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padc.homework.discoverrestrauantapp.R;
import com.padc.homework.discoverrestrauantapp.data.vos.Menu;
import com.padc.homework.discoverrestrauantapp.views.viewholder.ViewHolderExploredMenu;

public class ExploreMenuTabRVAdapter extends BaseRecyclerAdapter<ViewHolderExploredMenu, Menu> {

    @NonNull
    @Override
    public ViewHolderExploredMenu onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_view_explore_menu, viewGroup, false);
        return new ViewHolderExploredMenu(view);
    }

}
