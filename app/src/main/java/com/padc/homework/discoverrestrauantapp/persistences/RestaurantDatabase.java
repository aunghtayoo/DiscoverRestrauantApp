package com.padc.homework.discoverrestrauantapp.persistences;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.padc.homework.discoverrestrauantapp.data.vos.Menu;
import com.padc.homework.discoverrestrauantapp.data.vos.Restaurant;
import com.padc.homework.discoverrestrauantapp.persistences.daos.MenuDao;
import com.padc.homework.discoverrestrauantapp.persistences.daos.RestaurantDao;
import com.padc.homework.discoverrestrauantapp.utils.Constants;

import java.util.List;

@Database(entities = {Restaurant.class, Menu.class}, version = 11, exportSchema = true)
public abstract class RestaurantDatabase extends RoomDatabase {

    private static RestaurantDatabase objInstance;

    public abstract RestaurantDao restaurantDao();
    public abstract MenuDao menuDao();

    //private RestaurantDatabase(){}

    public static RestaurantDatabase getObjInstance(Context context){
        if(objInstance == null){
            objInstance = Room.databaseBuilder(context, RestaurantDatabase.class, Constants.RESTAURANT_DB_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return objInstance;
    }

    public boolean areRestaurantsExisted(){
        return !restaurantDao().getAllRestaurants().isEmpty();
    }
}
