package com.example.shopcafe.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.shopcafe.DrinkCart;
import com.example.shopcafe.User;

import java.util.List;

@Dao
public interface userDAO {

    @Insert
    void insertuser(User user);

    @Query("SELECT*FROM user")
    List<User> getlistuser();

    @Query("SELECT *FROM user limit 1")
    User getdata();

    @Query("SELECT * FROM user where username= :name")
    User findByName(String name);

    @Update
    void updateuser(User u);

    @Query("Delete from user")
    void deletetable();

}

