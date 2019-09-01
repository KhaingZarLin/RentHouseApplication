package com.example.renthouseapplication.network.dataagents;

import com.example.renthouseapplication.data.vos.RentVO;

import java.util.List;

public interface RentDataAgent {
    void getRent(String accessToken,GetRentFromNetworkDelegate delegate);

    interface GetRentFromNetworkDelegate{
        void onSuccess(List<RentVO> events);
        void onFailure(String errorMessage);
    }
}
