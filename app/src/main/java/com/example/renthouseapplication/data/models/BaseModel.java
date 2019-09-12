package com.example.renthouseapplication.data.models;

import android.content.Context;

import com.example.renthouseapplication.delegate.FragmentDelegateOne;
import com.example.renthouseapplication.network.dataagents.HttpUrlConnectionDataAgentImpl;
import com.example.renthouseapplication.network.dataagents.OkHttpUrlConnectionDataAgent;
import com.example.renthouseapplication.network.dataagents.RentDataAgent;
import com.example.renthouseapplication.persistences.RentDataBase;

public abstract class BaseModel {
    protected RentDataAgent rentDataAgent;
    protected RentDataBase rentDataBase;
    BaseModel(Context context){
       // rentDataAgent = HttpUrlConnectionDataAgentImpl.getObjInstance();
        //rentDataAgent = OkHttpUrlConnectionDataAgent.getObjInstance();
        rentDataAgent = HttpUrlConnectionDataAgentImpl.getObjInstance();
        rentDataBase=RentDataBase.getObjInstance(context);
    }

}
