package com.lab.savedata.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.lab.savedata.model.User;
import com.lab.savedata.R;
import com.lab.savedata.model.DataHolder;
import com.lab.savedata.model.User;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.lab.savedata.R;
import com.lab.savedata.helper.UserAdapter;
import com.lab.savedata.model.User;
import com.lab.savedata.model.DataHolder;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView noDataText;

    FloatingActionButton fbtnAddCollection;

    RecyclerView animeRecyclerView;
    RecyclerView.Adapter animeAdapter;
    RecyclerView.LayoutManager animeLayoutManager;

    private List<User> animeList = DataHolder.getInstance().users;

    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noDataText = findViewById(R.id.noDataTextMain);

        if (!animeList.isEmpty()){
            noDataText.setVisibility(View.INVISIBLE);
        }

        animeRecyclerView = findViewById(R.id.animeRecyclerViewMain);
        animeLayoutManager = new LinearLayoutManager(this);
        animeAdapter = new UserAdapter(animeList);

        animeRecyclerView.setLayoutManager(animeLayoutManager);
        animeRecyclerView.setAdapter(animeAdapter);

        fbtnAddCollection = findViewById(R.id.floatingActionButtonMain);

        fbtnAddCollection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AddUserActivity.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
}