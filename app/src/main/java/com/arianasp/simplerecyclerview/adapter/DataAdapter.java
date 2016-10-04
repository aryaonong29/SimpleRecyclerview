package com.arianasp.simplerecyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arianasp.simplerecyclerview.R;
import com.arianasp.simplerecyclerview.model.AndroidVersion;

import java.util.ArrayList;

/**
 * Created by mycomputer on 04/10/16.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private ArrayList<AndroidVersion> android;

    public DataAdapter(ArrayList<AndroidVersion> android){
        this.android = android;
    }


    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_row,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder holder, int position) {
        holder.tv_name.setText(android.get(position).getName());
        holder.tv_version.setText(android.get(position).getVer());
        holder.tv_api.setText(android.get(position).getApi());
    }

    @Override
    public int getItemCount() {
        return android.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_name,tv_version,tv_api;
        public ViewHolder(View v){
            super(v);
            tv_name = (TextView) v.findViewById(R.id.tv_name);
            tv_version = (TextView) v.findViewById(R.id.tv_version);
            tv_api = (TextView) v.findViewById(R.id.tv_api_level);
        }
    }
}
