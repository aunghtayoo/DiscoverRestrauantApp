package com.padc.homework.discoverrestrauantapp.views.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatRatingBar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.padc.homework.discoverrestrauantapp.R;
import com.padc.homework.discoverrestrauantapp.data.vos.Restaurant;
import com.padc.homework.discoverrestrauantapp.delegates.ExploreItemTabDelegate;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewHolderExplored extends BaseViewHolder<Restaurant> {

    ExploreItemTabDelegate exploreItemTabDelegate;

    @BindView(R.id.tv_name)
    TextView tvName;

    @BindView(R.id.tv_address)
    TextView tvAddress;

    @BindView(R.id.tv_rating_number)
    TextView tvRatingNumber;

    @BindView(R.id.tv_max_rating)
    TextView tvMaxRating;

    @BindView(R.id.tv_desc)
    TextView tvDetailDesc;

    @BindView(R.id.iv_menu)
    ImageView ivMenu;

    @BindView(R.id.iv_background)
    ImageView ivBackground;

    @BindView(R.id.rb_stars)
    AppCompatRatingBar appCompatRatingBar;

    public ViewHolderExplored(final ExploreItemTabDelegate exploreItemTabDelegate, @NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exploreItemTabDelegate.onTabItemExplored(mData.getId());
            }
        });
    }

    @Override
    public void bindData(Restaurant data) {

        mData = data;

        tvName.setText(data.getName());
        tvAddress.setText(data.getAddress());
        tvDetailDesc.setText(data.getDescription());
        tvMaxRating.setText("(100)");
        tvRatingNumber.setText(String.valueOf(data.getRating()));

        appCompatRatingBar.setRating(data.getRating());

        Glide.with(itemView)
                .load(data.getImageUrl())
                .into(ivBackground);

    }

}
