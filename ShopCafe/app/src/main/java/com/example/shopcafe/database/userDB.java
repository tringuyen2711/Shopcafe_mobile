package com.example.shopcafe.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.shopcafe.User;

@Database(entities = {User.class}, version = 1)
public abstract class userDB extends RoomDatabase {

    private static final String DATABASE_NAME="user.db";
    private static userDB instance;

    public static synchronized userDB getInstance(Context context){
        if(instance==null){
            instance= Room.databaseBuilder(context.getApplicationContext(), userDB.class,DATABASE_NAME)
                    .allowMainThreadQueries().build();
        }
        return instance;
    }

    public abstract userDAO userDAO();
}
