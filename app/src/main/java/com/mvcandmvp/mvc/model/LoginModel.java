package com.mvcandmvp.mvc.model;

import com.google.gson.Gson;
import com.mvcandmvp.mvc.Interface.ILogin;
import com.mvcandmvp.mvc.bean.LoginBean;
import com.mvcandmvp.mvc.callback.BeanCallback;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

// 执行网络请求类
public class LoginModel implements ILogin {


    @Override
    public void login(String name, String password, BeanCallback<LoginBean> beanCallback) {
        // ApiUrl 调用retrofit创建的接口类中的网络请求方法
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = new FormBody.Builder()
                .add("name", name)
                .add("password", password)
                .build();
        Request request = new Request.Builder().post(requestBody)
                .url("http://192.168.1.217:8080/a/task3.json")
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                beanCallback.OnError(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                assert response.body() != null;
//                if (response.body()==null){
//                    throw new AssertionError("body cannot be null");
//                }
                String json = response.body().string();
                Gson gson = new Gson();
                LoginBean loginBean = gson.fromJson(json,LoginBean.class);
                beanCallback.OnSuccess(loginBean);
            }
        });





    }

    
}
