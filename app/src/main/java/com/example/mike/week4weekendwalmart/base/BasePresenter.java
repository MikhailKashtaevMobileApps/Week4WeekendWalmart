package com.example.mike.week4weekendwalmart.base;

public interface BasePresenter< T > {

    void onAttach(T v);
    void onDetach();

}
