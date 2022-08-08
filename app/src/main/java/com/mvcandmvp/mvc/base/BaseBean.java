package com.mvcandmvp.mvc.base;

import java.io.Serializable;

public class BaseBean<T> extends Object implements Serializable {

    private int e;
    private String m;
    private T d;

    public int getE() {
        return e;
    }

    public String getM() {
        return m;
    }

    public T getData() {
        return d;
    }
}
