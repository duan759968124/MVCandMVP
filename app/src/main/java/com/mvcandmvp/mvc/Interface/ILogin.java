package com.mvcandmvp.mvc.Interface;


import com.mvcandmvp.mvc.bean.LoginBean;
import com.mvcandmvp.mvc.callback.BeanCallback;

public interface ILogin {

    void login(String name, String password, BeanCallback<LoginBean> beanCallback);


}
