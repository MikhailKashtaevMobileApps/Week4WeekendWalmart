package com.example.mike.week4weekendwalmart.ui.main;

import com.example.mike.week4weekendwalmart.base.BasePresenter;
import com.example.mike.week4weekendwalmart.base.BaseView;

public class MainContract {

    interface View extends BaseView{}
    interface Presenter extends BasePresenter<View>{}

}
