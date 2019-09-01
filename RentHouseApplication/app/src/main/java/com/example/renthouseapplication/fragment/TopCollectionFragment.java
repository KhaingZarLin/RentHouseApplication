package com.example.renthouseapplication.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.renthouseapplication.R;
import com.example.renthouseapplication.RentDetailActivity;
import com.example.renthouseapplication.adapter.TopCollectionAdapter;
import com.example.renthouseapplication.delegate.FragmentDelegateOne;


public class TopCollectionFragment extends Fragment implements FragmentDelegateOne  {
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    private FragmentDelegateOne fragmentDelegateOne;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_top_collection, container, false);
        recyclerView=view.findViewById(R.id.recyclerview);
        linearLayoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new TopCollectionAdapter());
        return view;
    }

    @Override
    public void onTapDElegate() {
//        Intent myIntent = new Intent(getActivity(), RentDetailActivity.class);
//        getActivity().startActivity(myIntent);
        Intent i = new Intent(getActivity(), RentDetailActivity.class);
        startActivity(i);
    }
}
