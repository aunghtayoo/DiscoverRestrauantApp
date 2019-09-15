package com.padc.homework.discoverrestrauantapp.delegates;

import android.content.Context;
import android.view.View;

public interface ExploreItemTabDelegate {
    void onTabItemExplored(int id);
    void onGetAllRestaurantData(Context context, View view);
    void onSearchItems(Context context, View view, String keyword);
}
