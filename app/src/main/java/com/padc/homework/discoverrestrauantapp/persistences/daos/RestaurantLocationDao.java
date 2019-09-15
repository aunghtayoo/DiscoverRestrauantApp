package com.padc.homework.discoverrestrauantapp.persistences.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.padc.homework.discoverrestrauantapp.data.vos.RestaurantLocation;

import java.util.List;

@Dao
public abstract class RestaurantLocationDao {

    @Insert
    public abstract void insertRestaurantLocation(List<RestaurantLocation> restaurantLocations);

    @Query("SELECT * FROM location WHERE restaurant_id=:id")
    public abstract List<RestaurantLocation> getRestaurantLocById(int id);
}
