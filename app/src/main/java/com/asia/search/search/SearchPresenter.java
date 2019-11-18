package com.asia.search.search;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import roomDB.SearchModel;

class SearchPresenter implements PresenterView {
    private static final String TAG = "SearchActivity";


    private SearchView mSearchView;
    private Context mContext;

    SearchPresenter(SearchView mSearchView, Context mContext) {
        this.mSearchView = mSearchView;
        this.mContext = mContext;


    }

    public PresenterView getView() {
        return this;
    }

    private List<SearchModel> mList = new ArrayList<>();//TODO: remove

    @Override
    public void getData() {
        //TODO: get data from fireBase
        mList.add(new SearchModel("123456789", "namea", "231222", "1231", "2019", "elhram", "kill", "1/9/2019", "3 years"));
        mList.add(new SearchModel("134567890", "nameb", "231222", "1231", "2019", "elhram", "kill", "1/9/2019", "3 years"));
        mList.add(new SearchModel("124567890", "namec", "231222", "1231", "2019", "elhram", "kill", "1/9/2019", "3 years"));
        mList.add(new SearchModel("123567890", "namee", "231222", "1231", "2019", "elhram", "kill", "1/9/2019", "3 years"));
        mList.add(new SearchModel("123467890", "namef", "231222", "1231", "2019", "elhram", "kill", "1/9/2019", "3 years"));
        mList.add(new SearchModel("123457890", "nameg", "231222", "1231", "2019", "elhram", "kill", "1/9/2019", "3 years"));
        mList.add(new SearchModel("123456890", "nameh", "231222", "1231", "2019", "elhram", "kill", "1/9/2019", "3 years"));
        mList.add(new SearchModel("123456790", "namei", "231222", "1231", "2019", "elhram", "kill", "1/9/2019", "3 years"));
        mList.add(new SearchModel("123456780", "namej", "231222", "1231", "2019", "elhram", "kill", "1/9/2019", "3 years"));
        mSearchView.setList(mList);
    }

    private List<SearchModel> mSearchList = new ArrayList<>();

    @Override
    public void searchBy(short type/*1 nationalId , 2 name*/, String value) {
        Log.d(TAG, "searchBy: list size = " + mList.size());
        mSearchList.clear();
        switch (type) {
            case 1:
                for (SearchModel model : mList) {
                    if (model.getNationalID().contains(value)) {
                        mSearchList.add(model);
                        Log.d(TAG, "searchBy:  " + model.getNationalID() + " mach " + value);
                    } else {
                        Log.d(TAG, "searchBy:  " + model.getNationalID() + "not mach " + value);
                    }
                }
                break;
            case 2:
                for (SearchModel model : mList) {
                    if (model.getName().contains(value)) {
                        mSearchList.add(model);
                    }
                }
                break;
            default:
                mSearchList = mList;
                break;

        }
        mSearchView.setList(mSearchList);
    }
}
