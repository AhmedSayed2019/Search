package com.asia.search.details;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.asia.search.R;

import java.util.ArrayList;
import java.util.List;

import roomDB.DetailsModel;

class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.ViewHolder> {


    //vars
    private List<DetailsModel> mCriminalsList;

    DetailsAdapter() {
        this.mCriminalsList = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_details_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        final DetailsModel object = mCriminalsList.get(position);


        holder.txVw_type.setText(object.getTypeName());
        holder.txVw_value.setText(object.getValue());



    }

    void setItem(DetailsModel model) {
        mCriminalsList.add(model);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mCriminalsList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView txVw_type, txVw_value;

        ViewHolder(View itemView) {
            super(itemView);


            txVw_type = itemView.findViewById(R.id.itemDetails_txVw_type);
            txVw_value = itemView.findViewById(R.id.itemDetails_txVw_value);


        }
    }
}






