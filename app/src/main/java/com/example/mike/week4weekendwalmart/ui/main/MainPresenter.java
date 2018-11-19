package com.example.mike.week4weekendwalmart.ui.main;

public class MainPresenter implements MainContract.Presenter {

    MainContract.View view;

    @Override
    public void onAttach(MainContract.View v) {
        this.view = v;
    }

    @Override
    public void onDetach() {
        this.view = null;
    }
}
