package com.example.renthouseapplication.network;

import com.example.renthouseapplication.network.response.GetRentResponse;
import com.example.renthouseapplication.utils.RentConstants;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RentApi {

    @FormUrlEncoded
    @POST(RentConstants.GET_EVENTS)
    Call<GetRentResponse> getAllEvent(@Field(RentConstants.PARAM_ACCESS_TOKEN) String accessToken);
}

