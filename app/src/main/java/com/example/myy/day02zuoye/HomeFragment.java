package com.example.myy.day02zuoye;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myy.day02zuoye.m.M;
import com.example.myy.day02zuoye.p.P;
import com.example.myy.day02zuoye.v.MyView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements MyView {


    private View view;
    private XRecyclerView xrv;
    private P p;
    private ArrayList<HomeBean.DataBean.DatasBean> list;
    private HomeAdapter homeAdapter;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_home, container, false);
        initView(inflate);
        p = new P(new M(), this);
        initData();
        return inflate;
    }

    private void initData() {
        p.homeData();
        homeAdapter.notifyDataSetChanged();
    }

    private void initView(View inflate) {
        xrv = (XRecyclerView) inflate.findViewById(R.id.xrv);
        xrv.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        homeAdapter = new HomeAdapter(list, getActivity());
        xrv.setAdapter(homeAdapter);
    }

    @Override
    public void homeYes(HomeBean homeBean) {
        list.addAll(homeBean.getData().getDatas());
        homeAdapter.notifyDataSetChanged();
    }

    @Override
    public void fuYes(FuBean fuBean) {

    }

    @Override
    public void No(String msg) {
        Log.e("错误", "No: "+msg );
    }
}
