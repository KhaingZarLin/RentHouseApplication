package com.example.renthouseapplication.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import com.example.renthouseapplication.R;
import com.example.renthouseapplication.data.vos.RentVO;
import com.example.renthouseapplication.delegate.FragmentDelegateOne;
import com.example.renthouseapplication.view.holder.TopCollectionViewHolder;

import java.util.ArrayList;
import java.util.List;


public class TopCollectionAdapter extends BaseAdapter<TopCollectionViewHolder,RentVO> implements Filterable {
    private FragmentDelegateOne fragmentDelegateOne;
    private List<RentVO> rentVOList;


    public TopCollectionAdapter(FragmentDelegateOne delegateOne) {
        this.fragmentDelegateOne = delegateOne;

    }

    @NonNull
    @Override
    public TopCollectionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemview= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_view,viewGroup,false);
        return new TopCollectionViewHolder(itemview,fragmentDelegateOne);
    }


    @Override
    public Filter getFilter() {
        return item;
    }
    private Filter item=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<RentVO> voList=new ArrayList<>();
            if (constraint==null || constraint.length()==0)
            {
                voList.addAll(rentVOList);
            }
            else
            {
                String filterpattern=constraint.toString().toLowerCase().trim();
                for (RentVO rentVO:rentVOList)
                {
                    if(rentVO.getName().toLowerCase().contains(filterpattern))
                    {
                        voList.add(rentVO);
                    }
                }
            }
            FilterResults filterResults=new FilterResults();
            filterResults.values=voList;

            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            rentVOList.clear();
            rentVOList.addAll((List)results.values);
            notifyDataSetChanged();
        }
    };

}
