package com.example.myy.day02zuoye.m;

import com.example.myy.day02zuoye.CallBack;
import com.example.myy.day02zuoye.DbBean;
import com.example.myy.day02zuoye.DbUtil;
import com.example.myy.day02zuoye.FuBean;
import com.example.myy.day02zuoye.HomeBean;
import com.example.myy.day02zuoye.ServerUtil;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class M implements MyModel{

    private DbBean bean;

    @Override
    public void homeData(final CallBack callBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ServerUtil.homeurl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ServerUtil serverUtil = retrofit.create(ServerUtil.class);
        Observable<HomeBean> homejie = serverUtil.homejie();
        homejie.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HomeBean homeBean) {
                        callBack.homeYes(homeBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.No(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void fuData(final CallBack callBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ServerUtil.fuurl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ServerUtil serverUtil = retrofit.create(ServerUtil.class);
        Observable<FuBean> fujie = serverUtil.fujie();
        fujie.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FuBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FuBean fuBean) {
                        callBack.fuYes(fuBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.No(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
