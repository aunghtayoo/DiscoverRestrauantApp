package com.padc.homework.discoverrestrauantapp.network.responses;

import com.google.gson.annotations.SerializedName;
import com.padc.homework.discoverrestrauantapp.data.vos.Restaurant;

import java.util.List;

public class GetRestaurantsResponse {

    @SerializedName("message")
    private String message;

    @SerializedName("code")
    private int code;

    @SerializedName("data")
    private List<Restaurant> restaurants;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public boolean isResponseOk(){
        return !restaurants.isEmpty();
    }
}
