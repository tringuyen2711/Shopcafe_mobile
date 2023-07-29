package com.example.shopcafe.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.shopcafe.RedeemDrink;

import java.util.List;

@Dao
public interface redeemDrinkDAO {

    @Insert
    void insertDrinkRedeem(RedeemDrink redeemDrink);

    @Query("select * from redeemdrink")
    List<RedeemDrink> getAllRedeem();

    @Query("select sum(drink_points) from redeemdrink")
    int getSumPoint();

    @Query("select * from redeemdrink")
    LiveData<List<RedeemDrink>> getAllLive();


}
