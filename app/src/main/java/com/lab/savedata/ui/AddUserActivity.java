package com.lab.savedata.ui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.lab.savedata.R;
import com.lab.savedata.model.User;
import com.lab.savedata.model.DataHolder;

import java.util.List;

public class AddUserActivity extends AppCompatActivity {

    TextInputLayout inputNameLayout, inputAgeLayout, inputAddressLayout;
    TextInputEditText inputName, inputAge, inputAddress;
    Button btnSaveData;

    private List<User> animeList = DataHolder.getInstance().users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        inputName = findViewById(R.id.inputNameTextCollection);
        inputAge = findViewById(R.id.inputAgeTextCollection);
        inputAddress = findViewById(R.id.inputAddressTextCollection);
        inputNameLayout = findViewById(R.id.inputNameLayoutCollection);
        inputAgeLayout = findViewById(R.id.inputAgeLayoutCollection);
        inputAddressLayout = findViewById(R.id.inputAddressLayoutCollection);

        btnSaveData = findViewById(R.id.saveButtonCollection);

        inputName.addTextChangedListener(collectionTextWatcher);
        inputAge.addTextChangedListener(collectionTextWatcher);
        inputAddress.addTextChangedListener(collectionTextWatcher);

        LoadingActivity loadingActivity = new LoadingActivity(AddUserActivity.this);

        btnSaveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = inputName.getText().toString();
                String age = inputAge.getText().toString();
                String address = inputAddress.getText().toString();

                loadingActivity.startLoadingActivity();

                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadingActivity.dismissLoadingActivity();

                        User user = new User(name, age, address);

                        animeList.add(user);

                        startActivity(new Intent(AddUserActivity.this, MainActivity.class));
                        finish();
                    }
                }, 3000);
            }
        });
    }

    private TextWatcher collectionTextWatcher = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String animeTitle = inputName.getText().toString();
            String numberOfEpisodes = inputAge.getText().toString();
            String writer = inputAddress.getText().toString();

            if (animeTitle.length() > 20) {
                inputName.setError("You can only input max. 20 characters long");
            } else {
                inputName.setError(null);
            }

            btnSaveData.setEnabled(!TextUtils.isEmpty(animeTitle) && !TextUtils.isEmpty(numberOfEpisodes) && !TextUtils.isEmpty(writer) && animeTitle.length() <= 20);
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
}