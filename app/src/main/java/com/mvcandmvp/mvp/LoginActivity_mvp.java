package com.mvcandmvp.mvp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.mvcandmvp.R;
import com.mvcandmvp.mvp.base.BaseBean;
import com.mvcandmvp.mvp.model.testBean;
import com.mvcandmvp.mvp.presenter.testPresenter;
import com.mvcandmvp.mvp.view.testView;

import java.util.HashMap;

public class LoginActivity_mvp extends AppCompatActivity implements testView<BaseBean<testBean>> {
    private static final String TAG = "LoginActivity_mvp";
    private com.mvcandmvp.mvp.presenter.testPresenter testPresenter;

    public static void start(Context context){
        Intent intent = new Intent(context, LoginActivity_mvp.class);
        context.startActivity(intent);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login_mvp);

        findViewById(R.id.button).setOnClickListener(v -> {
            testPresenter = new testPresenter();
            testPresenter.setView(this);
            HashMap<String,Object> hashMap = new HashMap<>();
            testPresenter.getData(hashMap);
        });


    }

    //返回失败(可以不用实现）
    @Override
    public void onError(String msg) {
        Log.e(TAG, "onError: " + msg);
    }

    //返回成功
    @Override
    public void onSuccess(@Nullable BaseBean<testBean> testBeanBaseModel) {
        Log.i(TAG, "onSuccess: ");
    }
}
