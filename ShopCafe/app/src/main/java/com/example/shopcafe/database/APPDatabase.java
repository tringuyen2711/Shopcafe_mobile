package com.example.shopcafe.database;
import android.content.Context;
import android.provider.CalendarContract;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.example.shopcafe.DrinkCart;
import com.example.shopcafe.OrderItem;
import com.example.shopcafe.User;

@Database(entities = {User.class, DrinkCart.class, OrderItem.class},version = 2)
public abstract class APPDatabase extends RoomDatabase {
    private static volatile APPDatabase INSTANCE;

    private static final String DATABASE_NAME = "Appdatabase";
    public static APPDatabase getInstance(Context context)
    {
        if(INSTANCE==null){
            INSTANCE= Room.databaseBuilder(context.getApplicationContext(), APPDatabase.class,DATABASE_NAME)
                    .allowMainThreadQueries().build();
        }
        return INSTANCE;
    }

    public abstract userDAO userDAO();
    public abstract drinkcartDAO drinkcartDAO();

    public abstract orderitemDAO orderitemDAO();
}
