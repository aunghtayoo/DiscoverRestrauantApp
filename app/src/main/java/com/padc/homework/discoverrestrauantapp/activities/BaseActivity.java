package com.padc.homework.discoverrestrauantapp.activities;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.padc.homework.discoverrestrauantapp.R;
import com.padc.homework.discoverrestrauantapp.data.models.ExploreModelImpl;

public abstract class BaseActivity extends AppCompatActivity {

    protected ExploreModelImpl exploreModel;

    public BaseActivity(){
        exploreModel = ExploreModelImpl.getObjInstance();
    }

    protected void showInfiniteSnackBar(String message){
        final Snackbar snackbar = Snackbar.make(getWindow().getDecorView(), message, Snackbar.LENGTH_INDEFINITE);
        snackbar.setAction(getResources().getString(R.string.lbl_snack_bar_ok), new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackbar.dismiss();
            }
        });
    }
}
