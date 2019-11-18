package com.asia.search.search;


import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.asia.search.R;

import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import roomDB.SearchModel;

public class SearchActivity extends AppCompatActivity implements SearchView {
    public static final String TAG = SearchActivity.class.getSimpleName();

    private SearchAdapter mAdapter;

    private Pattern numbersPattern = Pattern.compile("[0-9]*");
    private Pattern namesPattern = Pattern.compile("[a-zA-Z]*");

    private Context mContext;
    private PresenterView mPresenterView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        mContext = SearchActivity.this;
        mPresenterView = new SearchPresenter(this ,mContext).getView();

        initUI();

        mPresenterView.getData();
    }

    private void initUI() {
        final EditText edtx_filter = findViewById(R.id.search_edtx_criminaFilter);
        initializeRecyclerViewFromWitnTools();

        //add event
             Objects.requireNonNull(edtx_filter).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            //
            @Override
            public void afterTextChanged(Editable s) {
                String value = s.toString();
                Matcher numberMatcher = numbersPattern.matcher(value);
                Matcher nameMatcher = namesPattern.matcher(value);
                Log.d(TAG, "beforeTextChanged: value = " +value);

                if (numberMatcher.matches()) {
                    Log.d(TAG, "afterTextChanged: search with nID");
                    mPresenterView.searchBy((short) 1 , value);
                }else if (nameMatcher.matches()){
                    Log.d(TAG, "afterTextChanged: search with Name");
                    mPresenterView.searchBy((short) 2 , value);
                }else {
                    edtx_filter.setError(Html.fromHtml("<font color='black'>" + "Can not search with this text" + "</font>"));
                }
            }
        });




    }

    @Override
    public void setList(List<SearchModel> models) {
        mAdapter.setList(models);
    }

    @Override
    public void setItem(SearchModel model) {
        mAdapter.setItem(model);
    }

    private void initializeRecyclerViewFromWitnTools() {
        RecyclerView rcyVw_criminalsList = findViewById(R.id.search_rcyVw_criminalsList);
        LinearLayoutManager mLinearLayoutManagerFrom = new LinearLayoutManager(mContext);
        rcyVw_criminalsList.setLayoutManager(mLinearLayoutManagerFrom);
        mAdapter = new SearchAdapter(mContext);
        rcyVw_criminalsList.setAdapter(mAdapter);

    }


}
