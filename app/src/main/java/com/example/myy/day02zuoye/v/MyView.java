package com.example.myy.day02zuoye.v;

import com.example.myy.day02zuoye.FuBean;
import com.example.myy.day02zuoye.HomeBean;

public interface MyView {
    void homeYes(HomeBean homeBean);
    void fuYes(FuBean fuBean);
    void No(String msg);
}
