package com.padc.homework.discoverrestrauantapp.persistences.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.padc.homework.discoverrestrauantapp.data.vos.Menu;

import java.util.List;

@Dao
public abstract class MenuDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insertMenus(List<Menu> menuList);

    @Query("SELECT * FROM menu WHERE restaurant_id=:id")
    public abstract List<Menu> getMenusById(int id);

    @Query("SELECT * FROM menu")
    public abstract List<Menu> getAllMenus();
}
