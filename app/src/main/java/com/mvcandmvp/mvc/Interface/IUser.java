package com.mvcandmvp.mvc.Interface;

import com.mvcandmvp.mvc.bean.InfoBean;
import com.mvcandmvp.mvc.callback.BeanCallback;
import com.mvcandmvp.mvp.base.BaseBean;

public interface IUser {

    void getInfo(String number, BeanCallback<BaseBean<InfoBean>> beanCallback);

}
