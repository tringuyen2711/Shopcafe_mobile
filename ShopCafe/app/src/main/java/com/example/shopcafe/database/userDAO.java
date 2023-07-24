package com.example.shopcafe.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

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
}
