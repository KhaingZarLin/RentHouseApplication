package com.example.renthouseapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.renthouseapplication.data.models.RentModel;
import com.example.renthouseapplication.data.models.RentModelImpl;

public abstract class BaseActivity extends AppCompatActivity {
    protected RentModel rentModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rentModel= RentModelImpl.getObjInstance();
    }

    protected void showIndexSnackBar(String message)
    {
        final Snackbar snackbar=Snackbar.make(getWindow().getDecorView(),message,Snackbar.LENGTH_LONG);
        snackbar.setAction(getResources().getString(Integer.parseInt("OK")), new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackbar.dismiss();;
            }
        });
    }
}
