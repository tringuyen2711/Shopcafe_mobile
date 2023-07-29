package com.example.shopcafe;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.shopcafe.database.APPDatabase;

import java.util.List;

public class redeemViewModel extends AndroidViewModel {
    APPDatabase redeemDatabase;



    public redeemViewModel(@NonNull Application application) {
        super(application);
        redeemDatabase = APPDatabase.getInstance(application.getApplicationContext());
    }

    public LiveData<List<RedeemDrink>> getAllLiveData(){
        return redeemDatabase.redeemDrinkDAO().getAllLive();
    }

    public void insert(RedeemDrink redeemDrink)
    {
        redeemDatabase.redeemDrinkDAO().insertDrinkRedeem(redeemDrink);
    }

    public int getSumOfQuantity()
    {
        return redeemDatabase.redeemDrinkDAO().getSumPoint();
    }
}
