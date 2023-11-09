package com.mvcandmvp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;

import com.mvcandmvp.mvc.ui.LoginActivity_mvc;
import com.mvcandmvp.mvp.LoginActivity_mvp;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.to_login_mvc).setOnClickListener(view -> LoginActivity_mvc.start(getBaseContext()));
        findViewById(R.id.to_login_mvp).setOnClickListener(v -> LoginActivity_mvp.start(getBaseContext()));

    }
}