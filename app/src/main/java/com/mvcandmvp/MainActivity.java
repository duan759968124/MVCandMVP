package com.mvcandmvp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;

import com.mvcandmvp.mvc.ui.LoginActivity;

public class MainActivity extends AppCompatActivity {

    private AppCompatButton btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.to_login);
        btnLogin.setOnClickListener(view -> {
            LoginActivity.start(this);
        });

    }
}