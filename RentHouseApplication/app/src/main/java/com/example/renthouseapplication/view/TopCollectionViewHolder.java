package com.example.renthouseapplication.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.renthouseapplication.delegate.FragmentDelegateOne;

public class TopCollectionViewHolder extends RecyclerView.ViewHolder  {
    private FragmentDelegateOne fragmentDelegateOne;

    public TopCollectionViewHolder(View itemView, final FragmentDelegateOne delegateOne) {
        super(itemView);
        fragmentDelegateOne=delegateOne;

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delegateOne.onTapDElegate();
            }
        });
    }
}
