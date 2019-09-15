package com.padc.homework.discoverrestrauantapp;

import android.app.Application;

import com.padc.homework.discoverrestrauantapp.data.models.ExploreModelImpl;

public class RestaurantApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ExploreModelImpl.initializeExploreModelImpl(getApplicationContext());
    }
}
