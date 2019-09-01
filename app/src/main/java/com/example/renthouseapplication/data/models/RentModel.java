package com.example.renthouseapplication.data.models;

import com.example.renthouseapplication.data.vos.RentVO;

import java.util.List;

public interface RentModel {
    void getEvents(GetRentFromNetworkDelegate delegate);

    interface GetRentFromNetworkDelegate{
        void onSuccess(List<RentVO> events);
        void onFailure(String errorMessage);
    }
}
