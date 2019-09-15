package com.padc.homework.discoverrestrauantapp.network.dataagents;

import com.padc.homework.discoverrestrauantapp.data.vos.Restaurant;

import java.util.List;

public interface RestaurantDataAgent {

    void getRestaurants(GetRestaurantsFromModelDelegate delegate, String accessToken);

    interface GetRestaurantsFromModelDelegate{
        void onSuccess(List<Restaurant> restaurants);
        void onFailure(String message);
    }
}
