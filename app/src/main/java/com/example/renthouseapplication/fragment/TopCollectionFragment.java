package com.example.renthouseapplication.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.renthouseapplication.R;
import com.example.renthouseapplication.RentDetailActivity;
import com.example.renthouseapplication.adapter.TopCollectionAdapter;
import com.example.renthouseapplication.data.models.RentModel;
import com.example.renthouseapplication.data.models.RentModelImpl;
import com.example.renthouseapplication.data.vos.RentVO;
import com.example.renthouseapplication.delegate.FragmentDelegateOne;

import java.util.List;


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

        final TopCollectionAdapter topCollectionAdapter = new TopCollectionAdapter(this);
        recyclerView.setAdapter(topCollectionAdapter);

        RentModelImpl.getObjInstance().getEvents(new RentModel.GetRentFromNetworkDelegate() {
            @Override
            public void onSuccess(List<RentVO> events) {
                topCollectionAdapter.setNewData(events);
            }

            @Override
            public void onFailure(String errorMessage) {
                Log.d("Error Message",errorMessage);
            }
        });



        return view;
    }


    @Override
    public void onTapDElegate(int holdId) {
        Intent intent = RentDetailActivity.newIntent(getContext(), holdId);
        startActivity(intent);
    }



    }
