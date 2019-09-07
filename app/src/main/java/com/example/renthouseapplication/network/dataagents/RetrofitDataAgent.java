package com.example.renthouseapplication.network.dataagents;

import com.example.renthouseapplication.network.RentApi;
import com.example.renthouseapplication.network.response.GetRentResponse;
import com.example.renthouseapplication.utils.RentConstants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitDataAgent implements RentDataAgent {

    private static RetrofitDataAgent objInstance;
    private RentApi mEventApi;

    private RetrofitDataAgent()
    {
        final OkHttpClient okhttpClient=new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15,TimeUnit.SECONDS)
                .readTimeout(60,TimeUnit.SECONDS)
                .build();
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(RentConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okhttpClient)
                .build();
        mEventApi=retrofit.create(RentApi.class);

    }
    public static RetrofitDataAgent getObjInstance()
    {
        if (objInstance==null)
        {
            objInstance=new RetrofitDataAgent();
        }
        return objInstance;
    }
    public void getRent(String accessToken, final  GetRentFromNetworkDelegate delegate) {

        Call<GetRentResponse> eventCall=mEventApi.getAllEvent(accessToken);
        eventCall.enqueue(new Callback<GetRentResponse>() {
            @Override
            public void onResponse(Call<GetRentResponse> call, Response<GetRentResponse> response) {
                GetRentResponse getEventsResponse=response.body();
                delegate.onSuccess(getEventsResponse.getRentVOList());
            }

            @Override
            public void onFailure(Call<GetRentResponse> call, Throwable t) {
                delegate.onFailure(t.getLocalizedMessage());
            }
        });
    }
}
