package com.mvcandmvp.mvp.view;

import androidx.annotation.Nullable;

import com.mvcandmvp.mvp.base.BaseView;

public interface testView<T> extends BaseView {


    void onSuccess(@Nullable T t);

    @Override
    default void onError(String msg) {//已实现，子类可不实现
        onError(msg);//处理错误
    }

    ;
}
