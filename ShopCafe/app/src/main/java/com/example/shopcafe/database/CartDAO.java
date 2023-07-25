package com.example.shopcafe.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.shopcafe.Drinkcast;

import java.util.List;

@Dao
public interface CartDAO {

    @Insert
    void insertCart(Drinkcast drinkcast);

    @Query("select * from DrinkCast")
    List<Drinkcast> getListCart();


    @Query("delete from DrinkCast")
    void deleteCart();

    @Query("delete from DrinkCast where name = :detailsname")
    void deleteItemCart(String detailsname);
}
