package com.example.myy.day02zuoye;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ServerUtil {
    public String fuurl="https://gank.io/api/data/%E7%A6%8F%E5%88%A9/10/";
    @GET("6")
    Observable<FuBean> fujie();

    public String homeurl="https://www.wanandroid.com/project/list/1/";
    @GET("json?cid=294")
    Observable<HomeBean> homejie();
}
