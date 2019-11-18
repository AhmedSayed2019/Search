package com.asia.search.search;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.asia.search.R;
import com.asia.search.details.DetailsActivity;

import roomDB.SearchModel;

import java.util.ArrayList;
import java.util.List;

class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {


    //vars
    private List<SearchModel> mCriminalsList;
    private Context mContext;

    SearchAdapter(Context context) {
        this.mCriminalsList = new ArrayList<>();
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        final SearchModel object = mCriminalsList.get(position);


        holder.txVw_nationalId.setText(object.getNationalID());
        holder.txVw_name.setText(object.getName());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//
                Intent bus = new Intent(mContext, DetailsActivity.class);//create intent to start Message-activity
                bus.putExtra("NATIONAL_ID_KEY", object.getNationalID());
                bus.putExtra("NAME_KEY", object.getName());
                bus.putExtra("CASE_NUMBER_KEY", object.getCaseNumber());
                bus.putExtra("CRIMINAL_RECORD_NUMBER_KEY", object.getCriminalRecordNumber());
                bus.putExtra("YEAR_KEY", object.getYear());
                bus.putExtra("ADDRESS_KEY", object.getAddress());
                bus.putExtra("CRIMINAL_TYPE_KEY", object.getCriminalType());
                bus.putExtra("COURT_HEARING_DATE_KEY", object.getCourtHearingDate());
                bus.putExtra("JUDGE_KEY", object.getJudge());
                mContext.startActivity(bus);//start Message Activity

            }
        });

    }

    void setItem(SearchModel model) {
        mCriminalsList.add(model);
        notifyDataSetChanged();
    }

    void setList(List<SearchModel> models) {
        mCriminalsList = models;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mCriminalsList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView txVw_nationalId, txVw_name;

        ViewHolder(View itemView) {
            super(itemView);


            txVw_nationalId = itemView.findViewById(R.id.itemSearch_txVw_nationalId);
            txVw_name = itemView.findViewById(R.id.itemSearch_txVw_name);


        }
    }
}






