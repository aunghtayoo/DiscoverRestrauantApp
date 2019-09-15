package com.padc.homework.discoverrestrauantapp.data.vos;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "menu",
        foreignKeys = {@ForeignKey(entity = Restaurant.class, parentColumns = "restaurant_id_pk", childColumns = "restaurant_id")},
        indices = {@Index(value = "restaurant_id", unique = true)})
public class Menu {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "menu_id_pk")
    private int menuIdPK;

    @ColumnInfo(name = "restaurant_id")
    private int restaurantId;

    @SerializedName("id")
    @ColumnInfo(name = "id")
    private int id;

    @SerializedName("name")
    @ColumnInfo(name = "name")
    private String name;

    @SerializedName("price")
    @ColumnInfo(name = "price")
    private long price;

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public int getMenuIdPK() {
        return menuIdPK;
    }

    public void setMenuIdPK(int menuIdPK) {
        this.menuIdPK = menuIdPK;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
