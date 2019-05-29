package com.example.myy.day02zuoye;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTab;
    private ViewPager vp;
    private ArrayList<Fragment> fs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTab = (TabLayout) findViewById(R.id.mTab);
        vp = (ViewPager) findViewById(R.id.vp);

        fs = new ArrayList<>();
        fs.add(new HomeFragment());
        fs.add(new ShuFragment());
        fs.add(new FuFragment());

        VpAdapter vpAdapter = new VpAdapter(getSupportFragmentManager(), fs);
        vp.setAdapter(vpAdapter);

        mTab.addTab(mTab.newTab().setIcon(R.mipmap.ic_launcher).setText("首页"));
        mTab.addTab(mTab.newTab().setIcon(R.mipmap.ic_launcher).setText("数据"));
        mTab.addTab(mTab.newTab().setIcon(R.mipmap.ic_launcher).setText("福利"));

        mTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int p = tab.getPosition();
                vp.setCurrentItem(p);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
