package com.padc.homework.discoverrestrauantapp.network.dataagents;

import com.google.gson.Gson;
import com.padc.homework.discoverrestrauantapp.network.RestaurantApi;
import com.padc.homework.discoverrestrauantapp.network.responses.GetRestaurantsResponse;
import com.padc.homework.discoverrestrauantapp.utils.Constants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitRestaurantDataAgent implements RestaurantDataAgent{

    private static RetrofitRestaurantDataAgent objInstance;

    private RestaurantApi restaurantApi;

    private RetrofitRestaurantDataAgent(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .build();

        restaurantApi = retrofit.create(RestaurantApi.class);
    }

    public static RetrofitRestaurantDataAgent getObjInstance(){
        if(objInstance == null){
            objInstance = new RetrofitRestaurantDataAgent();
        }
        return objInstance;
    }

    @Override
    public void getRestaurants(final GetRestaurantsFromModelDelegate delegate, String accessToken) {
        //get data from api.
        Call<GetRestaurantsResponse> restaurantCall = restaurantApi.getAllRestaurant(accessToken);

        //do-async
        restaurantCall.enqueue(new Callback<GetRestaurantsResponse>() {
            @Override
            public void onResponse(Call<GetRestaurantsResponse> call, Response<GetRestaurantsResponse> response) {
                GetRestaurantsResponse getRestaurantsResponse = response.body();

                if(getRestaurantsResponse.isResponseOk()){
                    delegate.onSuccess(getRestaurantsResponse.getRestaurants());
                } else {
                    delegate.onFailure(getRestaurantsResponse.getMessage());
                }
            }

            @Override
            public void onFailure(Call<GetRestaurantsResponse> call, Throwable t) {
                delegate.onFailure(t.getLocalizedMessage());
            }
        });
    }
}
