package com.example.myy.day02zuoye;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShuFragment extends Fragment {


    private View view;
    private TextView title;
    

    public ShuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_shu, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        title = (TextView) inflate.findViewById(R.id.title);
        for (int i = 0; i < 20; i++) {
            DbBean dbBean = new DbBean(null, "小实训" + i);
            DbUtil.getDbUtil().insert(dbBean);
        }
        List<DbBean> query = DbUtil.getDbUtil().query();
        title.setText(query.toString());
    }
}
