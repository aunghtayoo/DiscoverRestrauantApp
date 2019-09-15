package com.padc.homework.discoverrestrauantapp.activities;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.padc.homework.discoverrestrauantapp.R;
import com.padc.homework.discoverrestrauantapp.adapters.DetailTabVPAdapter;
import com.padc.homework.discoverrestrauantapp.adapters.ExploreMenuTabRVAdapter;
import com.padc.homework.discoverrestrauantapp.data.vos.Menu;
import com.padc.homework.discoverrestrauantapp.data.vos.Restaurant;
import com.padc.homework.discoverrestrauantapp.delegates.ExploreDetailDetailsTabDelegate;
import com.padc.homework.discoverrestrauantapp.delegates.ExploreDetailMenuTabDelegate;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends BaseActivity implements ExploreDetailMenuTabDelegate, ExploreDetailDetailsTabDelegate {

    private static final String RES_EV_ID = "restraurant_extra_value_id";

    int id = 0;
    Restaurant restaurant;

    public static Intent getDetailIntent(Context context, int id){
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(RES_EV_ID, id);
        return intent;
    }

    @BindView(R.id.tl_detail)
    TabLayout tabLayout;

    @BindView(R.id.vp_detail)
    ViewPager viewPager;

    @BindView(R.id.ic_back)
    ImageView imgBack;

    @BindView(R.id.iv_detail_bg)
    ImageView imgBg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        id = getIntent().getIntExtra(RES_EV_ID,0);
        restaurant = exploreModel.getRestaurantById(id);

        Glide.with(this)
                .load(restaurant.getImageUrl())
                .into(imgBg);

        DetailTabVPAdapter adapter = new DetailTabVPAdapter(getSupportFragmentManager(), this, this);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onTabMenuItem(Context context, View view) {

        List<Menu> menuList = exploreModel.getAllMenuByRestaurantId(id);

        //bind-view
        RecyclerView rvDetailMenu = view.findViewById(R.id.rv_detail_menu);
        rvDetailMenu.setLayoutManager(new LinearLayoutManager(context, RecyclerView.VERTICAL, false));
        ExploreMenuTabRVAdapter adapter = new ExploreMenuTabRVAdapter();
        adapter.setNewData(menuList);
        rvDetailMenu.setAdapter(adapter);
    }

    @Override
    public void onTabDetailsItem(Context context, View view) {

        TextView detailName = view.findViewById(R.id.tv_detail_name);
        detailName.setText(restaurant.getName());

        TextView textDetail = view.findViewById(R.id.tv_detail_desc);
        textDetail.setText(restaurant.getDescription());

    }
}
