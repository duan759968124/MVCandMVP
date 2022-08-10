package com.mvcandmvp.mvp.view;

import androidx.annotation.Nullable;

import com.mvcandmvp.mvp.base.BaseView;

public interface testView<T> extends BaseView {


    void onSuccess(@Nullable T t);

}
