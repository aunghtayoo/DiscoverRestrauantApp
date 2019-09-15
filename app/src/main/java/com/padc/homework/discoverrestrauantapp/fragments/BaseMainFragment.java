package com.padc.homework.discoverrestrauantapp.fragments;

import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;

import com.padc.homework.discoverrestrauantapp.R;
import com.padc.homework.discoverrestrauantapp.data.models.ExploreModelImpl;

public abstract class BaseMainFragment extends Fragment {

    protected ExploreModelImpl exploreModelImpl;

    public BaseMainFragment(){
        exploreModelImpl = ExploreModelImpl.getObjInstance();
    }

    protected void showInfiniteSnackBar(String message){
        final Snackbar snackbar = Snackbar.make(getActivity().getWindow().getDecorView(), message, Snackbar.LENGTH_INDEFINITE);
        snackbar.setAction(getResources().getString(R.string.lbl_snack_bar_ok), new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackbar.dismiss();
            }
        });
    }
}
