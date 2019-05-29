package com.example.myy.day02zuoye.p;

import com.example.myy.day02zuoye.CallBack;
import com.example.myy.day02zuoye.DbBean;
import com.example.myy.day02zuoye.DbUtil;
import com.example.myy.day02zuoye.FuBean;
import com.example.myy.day02zuoye.HomeBean;
import com.example.myy.day02zuoye.m.MyModel;
import com.example.myy.day02zuoye.v.MyView;

import java.util.List;

public class P implements MyPresenter,CallBack {
    private MyModel model;
    private MyView view;
    private DbBean bean;

    public P(MyModel model, MyView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void homeYes(HomeBean homeBean) {
        view.homeYes(homeBean);
    }

    @Override
    public void fuYes(FuBean fuBean) {
        view.fuYes(fuBean);
    }

    @Override
    public void No(String msg) {
        view.No(msg);
    }

    @Override
    public void homeData() {
        model.homeData(this);
    }

    @Override
    public void fuData() {
        model.fuData(this);
    }

}
