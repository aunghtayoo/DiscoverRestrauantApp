package com.padc.homework.discoverrestrauantapp.network;

import com.padc.homework.discoverrestrauantapp.network.responses.GetRestaurantsResponse;
import com.padc.homework.discoverrestrauantapp.utils.Constants;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface RestaurantApi {
    @GET(Constants.GET_ALL_RESTAURANT)
    Call<GetRestaurantsResponse> getAllRestaurant(@Header(Constants.TOKEN_PARAM) String accessToken);
}
