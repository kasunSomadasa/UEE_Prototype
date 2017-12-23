package com.ueeprototype.ueeprototype;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by madupoorna on 12/21/17.
 */

public class emailRecyclerViewAdapter extends RecyclerView
        .Adapter<emailRecyclerViewAdapter
        .DataObjectHolder> {

    private ArrayList<EmailDataObject> mDataset;
    private static MyClickListener myClickListener;

    public static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {
        TextView emailAddr;
        TextView date;

        public DataObjectHolder(View itemView) {
            super(itemView);
            emailAddr = (TextView) itemView.findViewById(R.id.emailAddress);
            date = (TextView) itemView.findViewById(R.id.date);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getAdapterPosition(), v);
        }
    }

    public void setOnItemClickListener(emailRecyclerViewAdapter.MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public emailRecyclerViewAdapter(ArrayList<EmailDataObject> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public emailRecyclerViewAdapter.DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                                                            int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.email_card_view, parent, false);

        emailRecyclerViewAdapter.DataObjectHolder dataObjectHolder = new emailRecyclerViewAdapter.DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(emailRecyclerViewAdapter.DataObjectHolder holder, int position) {
        holder.emailAddr.setText(mDataset.get(position).getEmail());
        holder.date.setText(mDataset.get(position).getDate());
    }

    public void addItem(EmailDataObject dataObj, int index) {
        mDataset.add(index, dataObj);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }
}
