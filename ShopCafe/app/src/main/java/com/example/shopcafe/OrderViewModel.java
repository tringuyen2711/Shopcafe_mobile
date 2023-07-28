package com.example.shopcafe;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.shopcafe.database.APPDatabase;

import java.util.List;

public class OrderViewModel extends AndroidViewModel {

    APPDatabase appDatabaseorder;

    public OrderViewModel(@NonNull Application application) {
        super(application);
        appDatabaseorder = APPDatabase.getInstance(application.getApplicationContext());
    }

    public LiveData<List<OrderItem>> getAllOrder()
    {
        return appDatabaseorder.orderitemDAO().getLiveOrder();
    }

    public  LiveData<List<OrderItem>> deleteOrderItem(OrderItem orderItem)
    {
        appDatabaseorder.orderitemDAO().deleteItemOrder(orderItem);
        return appDatabaseorder.orderitemDAO().getLiveOrder();
    }

    public  LiveData<List<OrderItem>> update(OrderItem orderItem)
    {
        appDatabaseorder.orderitemDAO().updateOrder(orderItem);
        return appDatabaseorder.orderitemDAO().getLiveOrder();
    }

    public LiveData<List<OrderItem>> getOngoing(){
        return appDatabaseorder.orderitemDAO().getOngoingOrder();
    }

    public LiveData<List<OrderItem>> getHistory(){
        return appDatabaseorder.orderitemDAO().getHistoryOrder();
    }

    public int SumOfQuantity()
    {
        return appDatabaseorder.orderitemDAO().SumQuantity();
    }
}
