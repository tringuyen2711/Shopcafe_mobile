package com.example.shopcafe;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "redeemdrink")
public class RedeemDrink {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private int img;

    private String name;

    private String datetime;

    private int drink_points;

    public RedeemDrink(int img, String name, String datetime, int drink_points) {
        this.img = img;
        this.name = name;
        this.datetime = datetime;
        this.drink_points = drink_points;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public int getDrink_points() {
        return drink_points;
    }

    public void setDrink_points(int drink_points) {
        this.drink_points = drink_points;
    }
}
