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
public class FuFragment extends Fragment implements MyView {


    private View view;
    private XRecyclerView xrv2;
    private ArrayList<FuBean.ResultsBean> list;
    private FuAdapter fuAdapter;
    private P p;

    public FuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_fu, container, false);
        initView(inflate);
        p = new P(new M(), this);
        initData();
        return inflate;
    }

    private void initData() {
        p.fuData();
        fuAdapter.notifyDataSetChanged();
    }

    private void initView(View inflate) {
        xrv2 = (XRecyclerView) inflate.findViewById(R.id.xrv2);
        xrv2.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        fuAdapter = new FuAdapter(list, getActivity());
        xrv2.setAdapter(fuAdapter);
    }

    @Override
    public void homeYes(HomeBean homeBean) {

    }

    @Override
    public void fuYes(FuBean fuBean) {
        list.addAll(fuBean.getResults());
        fuAdapter.notifyDataSetChanged();
    }

    @Override
    public void No(String msg) {
        Log.e("错误", "No: "+msg );
    }
}
