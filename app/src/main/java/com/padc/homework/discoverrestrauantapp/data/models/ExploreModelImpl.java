package com.padc.homework.discoverrestrauantapp.data.models;

import android.content.Context;

import com.padc.homework.discoverrestrauantapp.data.vos.Menu;
import com.padc.homework.discoverrestrauantapp.data.vos.Restaurant;
import com.padc.homework.discoverrestrauantapp.network.dataagents.RestaurantDataAgent;
import com.padc.homework.discoverrestrauantapp.utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class ExploreModelImpl extends BaseModel implements ExploreModel{

    private static ExploreModelImpl objInstance;

    public static ExploreModelImpl getObjInstance(){
        if(objInstance == null){
            throw new RuntimeException(Constants.EM_EVENT_MODEL_NOT_INITIALIZED);
        }
        return objInstance;
    }

    public ExploreModelImpl(Context context) {
        super(context);
    }

    public static void initializeExploreModelImpl(Context context){
        objInstance = new ExploreModelImpl(context);
    }

    @Override
    public void getExploredRestaurants(final GetExploreRestaurantFromModelDelegate delegate) {

        if(mDatabase.areRestaurantsExisted()){

            //get data from Room DB.
            List<Restaurant> restaurantList = mDatabase.restaurantDao().getAllRestaurants();
            delegate.onSuccess(restaurantList);

        } else {

            //get data from Network Layer.
            mDataAgent.getRestaurants(new RestaurantDataAgent.GetRestaurantsFromModelDelegate() {
                @Override
                public void onSuccess(List<Restaurant> restaurants) {
                    mDatabase.restaurantDao().insertRestaurantAndMenus(restaurants, mDatabase.menuDao());
                    delegate.onSuccess(restaurants);
                }

                @Override
                public void onFailure(String message) {
                    delegate.onFailure(message);
                }
            }, Constants.DUMMY_ACCESS_TOKEN);

        }
    }

    public Restaurant getRestaurantById(int id){
        return mDatabase.restaurantDao().getRestaurantById(id);
    }

    public List<Menu> getAllMenuByRestaurantId(int id){
        return mDatabase.menuDao().getMenusById(id);
    }

    public List<Restaurant> getRestaurantByName(String name){
        List<Restaurant> restaurants = mDatabase.restaurantDao().getAllRestaurants();
        List<Restaurant> resultRestrauants = new ArrayList<>();
        for (Restaurant restaurant : restaurants) {
            if(restaurant.getName().contains(name)){
                resultRestrauants.add(restaurant);
            }
        }
        return resultRestrauants;
    }

}
