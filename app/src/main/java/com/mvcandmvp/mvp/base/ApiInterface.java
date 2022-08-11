package com.mvcandmvp.mvp.base;

import com.mvcandmvp.mvp.model.testBean;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

//接口类
public interface ApiInterface {


    @GET("")
    Observable<BaseBean<testBean>> getData(@Query("param") String param);


}
