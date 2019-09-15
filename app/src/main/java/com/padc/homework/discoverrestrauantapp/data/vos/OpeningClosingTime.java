package com.padc.homework.discoverrestrauantapp.data.vos;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "open_closing_time",
indices = {@Index(value = "time_id_pk", unique = true)},
foreignKeys = {@ForeignKey(entity = Restaurant.class, parentColumns = "id", childColumns = "restaurant_id")})
public class OpeningClosingTime {

    @ColumnInfo(name = "time_id_pk")
    private int timeIdPK;

    @ColumnInfo(name = "restaurant_id")
    private int restaurantId;

    @SerializedName("opening_time")
    @ColumnInfo(name = "opening_time")
    private String openingTime;

    @SerializedName("closing_time")
    @ColumnInfo(name = "closing_time")
    private String closingTime;

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public int getTimeIdPK() {
        return timeIdPK;
    }

    public void setTimeIdPK(int timeIdPK) {
        this.timeIdPK = timeIdPK;
    }

    public String getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(String openingTime) {
        this.openingTime = openingTime;
    }

    public String getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(String closingTime) {
        this.closingTime = closingTime;
    }
}
