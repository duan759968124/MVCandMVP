package com.mvcandmvp.mvp.presenter;

import com.mvcandmvp.mvp.base.ApiInterface;
import com.mvcandmvp.mvp.base.BaseBean;
import com.mvcandmvp.mvp.base.BaseObserver;
import com.mvcandmvp.mvp.base.BasePresenter;
import com.mvcandmvp.mvp.http.RetrofitUtil;
import com.mvcandmvp.mvp.model.testBean;
import com.mvcandmvp.mvp.view.testView;

import java.util.HashMap;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 适配器
 */
public class testPresenter extends BasePresenter<testView<BaseBean<testBean>>> {

    ApiInterface apiInterface = RetrofitUtil.getInstance().create(ApiInterface.class);

    public void getData(HashMap<String, Object> hashMap) {


        apiInterface.getData("")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<BaseBean<testBean>>() {
                    @Override
                    public void onNext(BaseBean<testBean> testBeanBaseModel) {
                        getView().onSuccess(testBeanBaseModel);
                    }

                    @Override
                    public void onError(Throwable e) {
                        getView().onError(e.getMessage());
                    }

                });
    }


}
