package com.example.shopcafe;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.shopcafe.database.APPDatabase;

import java.util.List;

public class CartViewModel extends AndroidViewModel {
    APPDatabase appDatabase;

    public CartViewModel(@NonNull Application application) {
        super(application);
        appDatabase = APPDatabase.getInstance(application.getApplicationContext());
    }

    public LiveData<List<DrinkCart>> getAllCart()
    {
        return appDatabase.drinkcartDAO().getLiveDTcart();
    }

    public LiveData<List<DrinkCart>> deleteCartItem(DrinkCart drinkCart)
    {
        appDatabase.drinkcartDAO().DeleteDrinkCart(drinkCart);
        return appDatabase.drinkcartDAO().getLiveDTcart();
    }

    public LiveData<List<DrinkCart>> deleteAll()
    {
        appDatabase.drinkcartDAO().deleteCart();
        return appDatabase.drinkcartDAO().getLiveDTcart();
    }

}
