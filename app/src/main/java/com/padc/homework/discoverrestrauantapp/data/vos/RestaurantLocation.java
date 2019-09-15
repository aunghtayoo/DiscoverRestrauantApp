package com.padc.homework.discoverrestrauantapp.data.vos;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "location",
indices = {@Index(value = "location_id_pk")},
foreignKeys = {@ForeignKey(entity = Restaurant.class, parentColumns = "id", childColumns = "restaurant_id")})
public class RestaurantLocation {

    @ColumnInfo(name = "location_id_pk")
    private int locationIdPk;

    @ColumnInfo(name = "restaurant_id")
    private int restaurantId;

    @SerializedName("latitude")
    @ColumnInfo(name = "latitude")
    private double latitude;

    @SerializedName("longitude")
    @ColumnInfo(name = "longitude")
    private double longitude;

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public int getLocationIdPk() {
        return locationIdPk;
    }

    public void setLocationIdPk(int locationIdPk) {
        this.locationIdPk = locationIdPk;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
