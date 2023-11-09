package com.mvcandmvp.mvc.Interface;


import com.mvcandmvp.mvc.bean.LoginBean;
import com.mvcandmvp.mvc.callback.BeanCallback;

/**
 * 接口类
 * 接口调用
 */
public interface ILogin {

    void login(String name, String password, BeanCallback<LoginBean> beanCallback);


}
