package com.example.renthouseapplication.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.renthouseapplication.R;
import com.example.renthouseapplication.data.vos.RentVO;
import com.example.renthouseapplication.delegate.FragmentDelegateOne;
import com.example.renthouseapplication.view.holder.TopCollectionViewHolder;

import java.util.List;


public class TopCollectionAdapter extends BaseAdapter<TopCollectionViewHolder,RentVO> {
    private FragmentDelegateOne fragmentDelegateOne;

    public TopCollectionAdapter(FragmentDelegateOne delegateOne) {
        this.fragmentDelegateOne = delegateOne;
    }

    @NonNull
    @Override
    public TopCollectionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemview= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_view,viewGroup,false);
        return new TopCollectionViewHolder(itemview,fragmentDelegateOne);
    }


}
