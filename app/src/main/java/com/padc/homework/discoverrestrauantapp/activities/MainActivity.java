package com.padc.homework.discoverrestrauantapp.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.padc.homework.discoverrestrauantapp.R;
import com.padc.homework.discoverrestrauantapp.adapters.ExploreListRVAdapter;
import com.padc.homework.discoverrestrauantapp.adapters.ExploreMenuTabRVAdapter;
import com.padc.homework.discoverrestrauantapp.data.models.ExploreModel;
import com.padc.homework.discoverrestrauantapp.data.vos.Restaurant;
import com.padc.homework.discoverrestrauantapp.delegates.ExploreDetailMenuTabDelegate;
import com.padc.homework.discoverrestrauantapp.delegates.ExploreItemTabDelegate;
import com.padc.homework.discoverrestrauantapp.fragments.ExploreFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements ExploreItemTabDelegate {

    @BindView(R.id.main_bottom_nv)
    BottomNavigationView bottomNavigationView;

    RecyclerView rvRestaurants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setNavigationItemSelectedListener();
    }

    @Override
    public void onTabItemExplored(int id) {
        Intent intent = DetailActivity.getDetailIntent(getApplicationContext(),id);
        startActivity(intent);
    }

    @Override
    public void onSearchItems(Context context, View view, String keyword) {
        rvRestaurants = view.findViewById(R.id.rv_explore);
        rvRestaurants.setLayoutManager(new LinearLayoutManager(context, RecyclerView.VERTICAL, false));
        final ExploreListRVAdapter adapter = new ExploreListRVAdapter(this);
        adapter.setNewData(exploreModel.getRestaurantByName(keyword));
        rvRestaurants.setAdapter(adapter);
    }

    private void setNavigationItemSelectedListener(){

        //do first load.
        loadExploreFragment();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int id = menuItem.getItemId();

                switch (id){
                    case R.id.mn_explore :
                        loadExploreFragment();
                        break;

                    case R.id.mn_category :
                        //cat
                        break;

                    case R.id.mn_camera :
                        //camera
                        break;

                    case R.id.mn_notification :
                        //noti
                        break;

                    case R.id.mn_person :
                        //person
                        break;
                }

                return true;
            }
        });
    }

    @Override
    public void onGetAllRestaurantData(final Context context, final View view) {

        final ExploreListRVAdapter adapter = new ExploreListRVAdapter(this);
        rvRestaurants = view.findViewById(R.id.rv_explore);
        rvRestaurants.setLayoutManager(new LinearLayoutManager(context, RecyclerView.VERTICAL, false));

        exploreModel.getExploredRestaurants(new ExploreModel.GetExploreRestaurantFromModelDelegate() {
            @Override
            public void onSuccess(List<Restaurant> restaurants) {
                adapter.setNewData(restaurants);
                rvRestaurants.setAdapter(adapter);
            }

            @Override
            public void onFailure(String message) {
                showInfiniteSnackBar(message);
            }
        });
    }

    private void loadExploreFragment(){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.layout_container, ExploreFragment.getObjInstance(this))
                .addToBackStack(null)
                .commit();
    }

}
