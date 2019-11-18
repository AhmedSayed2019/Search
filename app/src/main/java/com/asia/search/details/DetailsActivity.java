package com.asia.search.details;

import android.content.Intent;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.asia.search.R;

import roomDB.DetailsModel;
import services.ButtonAnim;

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener{
    private String nationalID, name, caseNumber, criminalRecordNumber, year, address, criminalType, courtHearingDate, judge;
    private DetailsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        initUI();
        getExtraData();
        setData();
    }

    private void getExtraData() {
        Intent bus = getIntent();

        nationalID = bus.getStringExtra("NATIONAL_ID_KEY");
        name = bus.getStringExtra("NAME_KEY");
        caseNumber = bus.getStringExtra("CASE_NUMBER_KEY");
        criminalRecordNumber = bus.getStringExtra("CRIMINAL_RECORD_NUMBER_KEY");
        year = bus.getStringExtra("YEAR_KEY");
        address = bus.getStringExtra("ADDRESS_KEY");
        criminalType = bus.getStringExtra("CRIMINAL_TYPE_KEY");
        courtHearingDate = bus.getStringExtra("COURT_HEARING_DATE_KEY");
        judge = bus.getStringExtra("JUDGE_KEY");


    }

    private void setData() {
        mAdapter.setItem(new DetailsModel(getString(R.string.national_id), nationalID));
        mAdapter.setItem(new DetailsModel(getString(R.string.name), name));
        mAdapter.setItem(new DetailsModel(getString(R.string.caseNumber), caseNumber));
        mAdapter.setItem(new DetailsModel(getString(R.string.criminalRecordNumber), criminalRecordNumber));
        mAdapter.setItem(new DetailsModel(getString(R.string.year), year));
        mAdapter.setItem(new DetailsModel(getString(R.string.address), address));
        mAdapter.setItem(new DetailsModel(getString(R.string.criminalType), criminalType));
        mAdapter.setItem(new DetailsModel(getString(R.string.courtHearingDate), courtHearingDate));
        mAdapter.setItem(new DetailsModel(getString(R.string.judge), judge));
    }

    private void initUI() {
        findViewById(R.id.toolbarSearch_linLay_search).setOnClickListener(this);
        initializeRecyclerViewFromWitnTools();
    }

    private void initializeRecyclerViewFromWitnTools() {
        RecyclerView rcyVw_criminalsList = findViewById(R.id.search_rcyVw_criminalsList);
        LinearLayoutManager mLinearLayoutManagerFrom = new LinearLayoutManager(DetailsActivity.this);
        rcyVw_criminalsList.setLayoutManager(mLinearLayoutManagerFrom);
        mAdapter = new DetailsAdapter();
        rcyVw_criminalsList.setAdapter(mAdapter);

    }

    //setting animation
    @Override
    public void onClick(final View v) {

        ViewCompat.animate(v)
                .setDuration(150)
                .scaleX(0.9f)
                .scaleY(0.9f)
                .setInterpolator(new ButtonAnim())
                .setListener(new ViewPropertyAnimatorListener() {
                    @Override
                    public void onAnimationStart(final View view) {

                    }

                    @Override
                    public void onAnimationEnd(final View view) {
                        if (v.getId() == R.id.toolbarSearch_linLay_search) {
                            onBackPressed();
                        }


                    }

                    @Override
                    public void onAnimationCancel(final View view) {

                    }
                })
                .withLayer()
                .start();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
