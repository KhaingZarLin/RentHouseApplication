package com.example.renthouseapplication.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.renthouseapplication.R;
import com.example.renthouseapplication.delegate.FragmentDelegateOne;
import com.example.renthouseapplication.view.TopCollectionViewHolder;

public class TopCollectionAdapter extends RecyclerView.Adapter {
    FragmentDelegateOne fragmentDelegateOne;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemview= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_view,viewGroup,false);
        return new TopCollectionViewHolder(itemview,fragmentDelegateOne);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
