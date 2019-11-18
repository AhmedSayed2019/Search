package com.asia.search.search;

interface PresenterView {

    void getData();

    void searchBy(short type/*1 nationalId , 2 name*/, String value);
}
