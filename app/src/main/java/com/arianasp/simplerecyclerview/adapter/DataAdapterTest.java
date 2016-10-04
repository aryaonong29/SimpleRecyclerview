package com.arianasp.simplerecyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arianasp.simplerecyclerview.R;
import com.arianasp.simplerecyclerview.model.DataVersion;

import java.util.ArrayList;

/**
 * Created by mycomputer on 04/10/16.
 */

public class DataAdapterTest extends RecyclerView.Adapter<DataAdapterTest.ViewHolder> {
    private ArrayList<DataVersion> data;

    public DataAdapterTest(ArrayList<DataVersion> data){
        this.data = data;
    }


    @Override
    public DataAdapterTest.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_data,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(DataAdapterTest.ViewHolder holder, int position) {
        holder.tv_id.setText(data.get(position).getId());
        holder.tv_first_name.setText(data.get(position).getFirst_name());
        holder.tv_last_name.setText(data.get(position).getLast_name());
        holder.tv_address.setText(data.get(position).getAddress());
        holder.tv_telephone.setText(data.get(position).getTelephone());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_id,tv_first_name,tv_last_name,tv_address,tv_telephone;
        public ViewHolder(View v){
            super(v);
            tv_id = (TextView) v.findViewById(R.id.tv_id);
            tv_first_name = (TextView) v.findViewById(R.id.tv_first_name);
            tv_last_name = (TextView) v.findViewById(R.id.tv_last_name);
            tv_address =(TextView) v.findViewById(R.id.tv_address);
            tv_telephone = (TextView) v.findViewById(R.id.tv_telephone);
        }
    }
}
