package com.padc.homework.discoverrestrauantapp.data.models;

import android.content.Context;

import com.padc.homework.discoverrestrauantapp.network.dataagents.RetrofitRestaurantDataAgent;
import com.padc.homework.discoverrestrauantapp.persistences.RestaurantDatabase;

public abstract class BaseModel {

    protected RestaurantDatabase mDatabase;
    protected RetrofitRestaurantDataAgent mDataAgent;

    public BaseModel(Context context) {
        mDatabase = RestaurantDatabase.getObjInstance(context);
        mDataAgent = RetrofitRestaurantDataAgent.getObjInstance();
    }

}
