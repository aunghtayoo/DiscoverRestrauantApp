package com.padc.homework.discoverrestrauantapp.data.models;

import com.padc.homework.discoverrestrauantapp.data.vos.Restaurant;

import java.util.List;

public interface ExploreModel {

    void getExploredRestaurants(GetExploreRestaurantFromModelDelegate delegate);

    interface GetExploreRestaurantFromModelDelegate{
        void onSuccess(List<Restaurant> restaurants);
        void onFailure(String message);
    }
}
