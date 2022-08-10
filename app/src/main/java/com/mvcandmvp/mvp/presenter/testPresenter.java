package com.mvcandmvp.mvp.presenter;

import com.mvcandmvp.mvp.base.ApiInterface;
import com.mvcandmvp.mvp.base.BaseModel;
import com.mvcandmvp.mvp.base.BaseObserver;
import com.mvcandmvp.mvp.base.BasePresenter;
import com.mvcandmvp.mvp.http.RetrofitUtil;
import com.mvcandmvp.mvp.model.testBean;
import com.mvcandmvp.mvp.view.testView;

import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 适配器
 */
public class testPresenter extends BasePresenter<testView<BaseModel<testBean>>> {

    public void getData(HashMap<String, Object> hashMap) {
        ApiInterface apiInterface = RetrofitUtil.getInstance().create(ApiInterface.class);

        apiInterface.getData("")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<BaseModel<testBean>>() {
                    @Override
                    public void onNext(BaseModel<testBean> testBeanBaseModel) {
                        getView().onSuccess(testBeanBaseModel);
                    }

                    @Override
                    public void onError(Throwable e) {
                        getView().onError(e.getMessage());
                    }

                });
    }


}
