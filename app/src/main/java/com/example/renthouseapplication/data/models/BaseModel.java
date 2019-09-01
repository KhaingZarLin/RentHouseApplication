package com.example.renthouseapplication.data.models;

import com.example.renthouseapplication.network.dataagents.HttpUrlConnectionDataAgentImpl;
import com.example.renthouseapplication.network.dataagents.RentDataAgent;

public abstract class BaseModel {
    protected RentDataAgent rentDataAgent;
    BaseModel(){
        rentDataAgent = HttpUrlConnectionDataAgentImpl.getObjInstance();
    }
}
