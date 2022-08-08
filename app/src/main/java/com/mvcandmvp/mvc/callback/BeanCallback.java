package com.mvcandmvp.mvc.callback;

//回调接口
public interface BeanCallback<T> {

    void OnError(String msg);

    void OnSuccess(T t);

}
