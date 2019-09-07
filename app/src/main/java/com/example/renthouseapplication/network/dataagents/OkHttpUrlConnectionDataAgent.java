package com.example.renthouseapplication.network.dataagents;

import android.os.AsyncTask;

import com.example.renthouseapplication.network.response.GetRentResponse;
import com.example.renthouseapplication.utils.RentConstants;
import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpUrlConnectionDataAgent implements RentDataAgent {
    private static OkHttpUrlConnectionDataAgent objInstance;
    private OkHttpClient mhttpClient;
    @Override
    public void getRent(String accessToken, GetRentFromNetworkDelegate delegate) {
        new GetEventTask(mhttpClient,accessToken,delegate).execute();
    }

    private OkHttpUrlConnectionDataAgent()
    {
        mhttpClient=new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15,TimeUnit.SECONDS)
                .readTimeout(60,TimeUnit.SECONDS)
                .build();
    }
    public static OkHttpUrlConnectionDataAgent getObjInstance()
    {
        if (objInstance==null)
        {
            objInstance=new OkHttpUrlConnectionDataAgent();
        }
        return objInstance;
    }

public static class GetEventTask extends AsyncTask<Void,Void, GetRentResponse>
{
    private String access_Token;
    private GetRentFromNetworkDelegate rentFromNetworkDelegate;
    private OkHttpClient httpClient;

    public GetEventTask(OkHttpClient mhttpClient, String accessToken, GetRentFromNetworkDelegate delegate) {
        access_Token=accessToken;
        rentFromNetworkDelegate=delegate;
        httpClient=mhttpClient;
    }
    @Override
    protected GetRentResponse doInBackground(Void... voids) {
        RequestBody forBody=new FormBody.Builder()
                .add(RentConstants.DUAMY_ACCESS_TOKEN,access_Token)
                .build();
       Request request=new Request.Builder()
                .url(RentConstants.BASE_URL+RentConstants.GET_EVENTS)
                .post(forBody)
                .build();
        try{
            Response response=httpClient.newCall(request).execute();
            if (response.isSuccessful())
            {
                String responseString=response.body().string();
                GetRentResponse getEventsResponse=new Gson().fromJson(responseString,GetRentResponse.class);
                return getEventsResponse;
            }
        }catch (Exception e)
        {

        }
        return null;
    }
    protected void onPostExecute(GetRentResponse rentsResponse)
    {
        super.onPostExecute(rentsResponse);
        if (rentsResponse!=null)
        {
            if(rentsResponse.isResponseOk())
            {
                rentFromNetworkDelegate.onSuccess(rentsResponse.getRentVOList());
            }
            else {
                rentFromNetworkDelegate.onFailure(rentsResponse.getMessage());
            }
        }
        else
        {
            rentFromNetworkDelegate.onFailure(RentConstants.EM_NULL_EVENT_RESPONSE);
        }
    }
}

}
