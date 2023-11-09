package com.mvcandmvp.mvc.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.mvcandmvp.BuildConfig;
import com.mvcandmvp.R;
import com.mvcandmvp.mvc.bean.InfoBean;
import com.mvcandmvp.mvc.bean.LoginBean;
import com.mvcandmvp.mvc.callback.BeanCallback;
import com.mvcandmvp.mvc.model.LoginModel;
import com.mvcandmvp.mvc.model.UserModel;
import com.mvcandmvp.mvp.base.BaseBean;

//view 及 controller层
public class LoginActivity_mvc extends AppCompatActivity  {

    private static final String TAG = "LoginActivity";

    private AppCompatButton btnLogin;
    private AppCompatButton btnUserInfo;
    private AppCompatButton btnAbout;
    private LoginModel mLoginModel;
    private UserModel userModel;


    public static void start(Context context) {
        Intent intent = new Intent(context, LoginActivity_mvc.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_mvc);

        mLoginModel = new LoginModel();
        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(view -> {
            mLoginModel.login("name", "password", new BeanCallback<LoginBean>() {

                @Override
                public void OnError(String msg) {
                    Log.e(TAG, "OnError: " + msg);
                }

                @Override
                public void OnSuccess(LoginBean data) {
                    Log.i(TAG, "OnSuccess: " + data.getMessage());
                }
            });
        });
        userModel = new UserModel();
        btnUserInfo = findViewById(R.id.btn_userinfo);
        btnUserInfo.setOnClickListener(view -> {
            userModel.getInfo("liushuangzeng", new BeanCallback<BaseBean<InfoBean>>() {
                @Override
                public void OnError(String msg) {
                    Log.e(TAG, "OnError: " + msg);
                }

                @Override
                public void OnSuccess(BaseBean<InfoBean> infoBeanBaseBean) {
                    Log.i(TAG, "OnSuccess: " + infoBeanBaseBean.getData().getName());
                }
            });
        });

        btnAbout = findViewById(R.id.btn_about);



        btnAbout.setOnClickListener(v -> {
            Toast.makeText(this, "v"+ BuildConfig.VERSION_NAME, Toast.LENGTH_SHORT).show();
        });
    }


}