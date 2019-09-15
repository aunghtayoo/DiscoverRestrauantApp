package com.padc.homework.discoverrestrauantapp.persistences.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.padc.homework.discoverrestrauantapp.data.vos.Menu;
import com.padc.homework.discoverrestrauantapp.data.vos.Restaurant;

import java.util.ArrayList;
import java.util.List;

@Dao
public abstract class RestaurantDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insertRestaurant(List<Restaurant> restaurants);

    @Query("SELECT * from restaurant")
    public abstract List<Restaurant> getAllRestaurants();

    @Query("SELECT * from restaurant WHERE id=:id")
    public abstract Restaurant getRestaurantById(int id);

    @Insert
    public void insertRestaurantAndMenus(List<Restaurant> restaurants, MenuDao menuDao){

        List<Menu> menuList = new ArrayList<>();

        for (Restaurant restaurant : restaurants) {
            for(Menu menu :restaurant.getMenusList()){
                menu.setRestaurantId(restaurant.getId());
            }
            menuList.addAll(restaurant.getMenusList());
        }

        insertRestaurant(restaurants);
        menuDao.insertMenus(menuList);
    }
}
