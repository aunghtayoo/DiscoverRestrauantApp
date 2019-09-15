package com.padc.homework.discoverrestrauantapp.persistences.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.padc.homework.discoverrestrauantapp.data.vos.OpeningClosingTime;

@Dao
public abstract class OpenCloseTimeDao {

    @Insert
    public abstract void insertOpenCloseTime(OpeningClosingTime openingClosingTime);

    @Query("SELECT * FROM open_closing_time WHERE restaurant_id=:id")
    public abstract OpeningClosingTime findOpenCloseTimeById(int id);
}
