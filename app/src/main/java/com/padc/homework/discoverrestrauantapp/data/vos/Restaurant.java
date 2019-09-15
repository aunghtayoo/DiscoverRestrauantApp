package com.padc.homework.discoverrestrauantapp.data.vos;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "restaurant",
indices = {@Index(value = "id", unique = true)})
public class Restaurant {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "restaurant_id_pk")
    private int restaurantIdPK;

    @SerializedName("id")
    @ColumnInfo(name = "id")
    private int id;

    @SerializedName("name")
    @ColumnInfo(name = "name")
    private String name;

    @SerializedName("image_url")
    @ColumnInfo(name = "image_url")
    private String imageUrl;

    @SerializedName("address")
    @ColumnInfo(name = "address")
    private String address;

    @SerializedName("description")
    @ColumnInfo(name = "description")
    private String description;

    @SerializedName("opening_closing_times")
    @Ignore
    private OpeningClosingTime openingClosingTime;

    @SerializedName("rating")
    @ColumnInfo(name = "rating")
    private float rating;

    @SerializedName("restaurant_location")
    @Ignore
    private RestaurantLocation restaurantLocation;

    @SerializedName("menus")
    @Ignore
    private List<Menu> menusList;

    public int getRestaurantIdPK() {
        return restaurantIdPK;
    }

    public void setRestaurantIdPK(int restaurantIdPK) {
        this.restaurantIdPK = restaurantIdPK;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OpeningClosingTime getOpeningClosingTime() {
        return openingClosingTime;
    }

    public void setOpeningClosingTime(OpeningClosingTime openingClosingTime) {
        this.openingClosingTime = openingClosingTime;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public RestaurantLocation getRestaurantLocation() {
        return restaurantLocation;
    }

    public void setRestaurantLocation(RestaurantLocation restaurantLocation) {
        this.restaurantLocation = restaurantLocation;
    }

    public List<Menu> getMenusList() {
        return menusList;
    }

    public void setMenusList(List<Menu> menusList) {
        this.menusList = menusList;
    }
}
