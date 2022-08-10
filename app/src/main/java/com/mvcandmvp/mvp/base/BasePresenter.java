package com.mvcandmvp.mvp.base;

public class BasePresenter<T> {

    private T view;

    public T getView() {
        return view;
    }

    public void setView(T view) {
        this.view = view;
    }

    public void onDetach() {
        if (null != view) {
            view = null;
        }
    }
}
