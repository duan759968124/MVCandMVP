package com.mvcandmvp.mvc.Interface;

import com.mvcandmvp.mvc.base.BaseBean;
import com.mvcandmvp.mvc.bean.InfoBean;
import com.mvcandmvp.mvc.callback.BeanCallback;

public interface IUser {

    void getInfo(String number, BeanCallback<BaseBean<InfoBean>> beanCallback);

}
