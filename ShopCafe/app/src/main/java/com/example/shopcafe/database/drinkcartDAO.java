package com.example.shopcafe.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.shopcafe.DrinkCart;

import java.util.List;

@Dao
public interface drinkcartDAO {

    @Insert
    void insertCart(DrinkCart drinkcart);

    @Query("select * from drinkcart")
    List<DrinkCart> getListCart();


    @Query("delete from drinkcart")
    void deleteCart();

    @Query("delete from drinkcart where name = :detailsname")
    void deleteItemCart(String detailsname);

    @Query("select * from drinkcart")
    LiveData<List<DrinkCart>> getLiveDTcart();

    @Delete
    void DeleteDrinkCart(DrinkCart drinkCart);
}
