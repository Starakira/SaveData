package com.lab.savedata.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;

import com.lab.savedata.R;

public class LoadingActivity {
    private Activity activity;
    private AlertDialog alertDialog;

    LoadingActivity(Activity activity){
        this.activity = activity;
    }

    void startLoadingActivity() {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        LayoutInflater inflater = activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.activity_loading, null));
        builder.setCancelable(false);

        alertDialog = builder.create();
        alertDialog.show();
    }

    void dismissLoadingActivity(){
        alertDialog.dismiss();
    }
}
