package com.mvcandmvp.mvc.model;

import com.google.gson.Gson;
import com.mvcandmvp.mvc.Interface.IUser;
import com.mvcandmvp.mvc.bean.InfoBean;
import com.mvcandmvp.mvc.callback.BeanCallback;
import com.mvcandmvp.mvc.gson.ParameterizedTypeImpl;
import com.mvcandmvp.mvp.base.BaseBean;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
//M层
public class UserModel implements IUser {

    @Override
    public void getInfo(String number, BeanCallback<BaseBean<InfoBean>> beanCallback) {
        OkHttpClient okHttpClient = new OkHttpClient();
        String url = "https://txd.tongji.edu.cn/api/user/get-tongji-user-info?number=liushuangzeng";
        Request request = new Request.Builder().get().url(url).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                beanCallback.OnError(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                assert response.body() != null;
                String json = response.body().toString();
                Gson gson = new Gson();
                Type type = getClass().getGenericSuperclass();
                if (type instanceof ParameterizedType){
                    Type[] types = ((ParameterizedType) type).getActualTypeArguments();
                    Type ty = new ParameterizedTypeImpl(BaseBean.class, new Type[]{types[0]});
                    BaseBean<InfoBean> data = gson.fromJson(json,ty);
                    beanCallback.OnSuccess(data);
                }
            }
        });
    }

}
