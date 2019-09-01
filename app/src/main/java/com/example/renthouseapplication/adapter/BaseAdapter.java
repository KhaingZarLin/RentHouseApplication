package com.example.renthouseapplication.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.example.renthouseapplication.view.holder.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;


public abstract class BaseAdapter<T extends BaseViewHolder<w>,w> extends RecyclerView.Adapter<T> {
    private List<w> mData;

    public BaseAdapter() {
        this.mData=new ArrayList<>();
    }

    @Override
    public void onBindViewHolder(@NonNull T viewHolder, int position) {
        viewHolder.bindData(mData.get(position));
    }

    @Override
    public int getItemCount() {
        if (mData!=null)
        {
            return mData.size();
        }
        else
        {
            return 0;
        }
    }

    public void setNewData(List<w> data)
    {
        mData=data;
        notifyDataSetChanged();
    }
}
