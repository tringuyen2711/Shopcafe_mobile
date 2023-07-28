package com.example.shopcafe.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.shopcafe.OrderItem;

import java.util.List;

@Dao
public interface orderitemDAO {

    @Insert
    void insertOrder(OrderItem orderItem);

    @Query("select * from orderitem")
    List<OrderItem> getListOrder();

    @Query("delete from orderitem")
    void deleteorder();

    @Query("select * from orderitem")
    LiveData<List<OrderItem>> getLiveOrder();

    @Query("select * from orderitem where state =1")
    LiveData<List<OrderItem>> getOngoingOrder();

    @Query("select * from orderitem where state =0")
    LiveData<List<OrderItem>> getHistoryOrder();
    @Delete
    void deleteItemOrder(OrderItem orderItem);

    @Update
    void updateOrder(OrderItem orderItem);

    @Query("select sum(quantity) from orderitem")
    int SumQuantity();
}
