package com.example.renthouseapplication;

import android.app.Application;

import com.example.renthouseapplication.data.models.RentModelImpl;

public class RentApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RentModelImpl.initializeRentModel(getApplicationContext());
    }
}
