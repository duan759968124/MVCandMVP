package com.mvcandmvp.mvp.http;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.mvcandmvp.mvp.base.Api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtil {

    public static RetrofitUtil instance = null;
    private final Retrofit retrofit;


    public static RetrofitUtil getInstance(){
        if (instance ==null){
            synchronized (RetrofitUtil.class){
                if (instance==null){
                    instance = new RetrofitUtil();
                }
            }
        }
        return instance;
    }


    public RetrofitUtil(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .connectTimeout(1000, TimeUnit.SECONDS)
                .readTimeout(1000,TimeUnit.MILLISECONDS)
                .writeTimeout(1000,TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();
        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(Api.BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

    }

    public <T>T create(Class<T> service){
        return retrofit.create(service);
    }





}
