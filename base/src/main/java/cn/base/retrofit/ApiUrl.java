package cn.base.retrofit;

import cn.base.bean.Bean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiUrl {


    /**
     * 有效链接
     */


    /**
     * TODO Get请求
     */
    @GET("")
    Observable<Bean> login(@Query("name") String name, @Query("password") String password);


    /**
     * TODO POST请求
     */


    /**
     * TODO DELETE
     */


    /**
     * TODO PUT
     */


    /**
     * TODO 文件上传
     */


    /**
     * 多文件上传
     */


    /**
     * 来自https://blog.csdn.net/impure/article/details/79658098
     * @Streaming 这个注解必须添加，否则文件全部写入内存，文件过大会造成内存溢出
     */
}
