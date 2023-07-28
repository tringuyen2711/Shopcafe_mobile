package com.example.shopcafe;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "orderitem")
public class OrderItem {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String date;

    private String name;

    private  String address;

    private int state;



    public String price;

    public int getState() {
        return state;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public OrderItem(String date, String name, String address, int state, String price) {
        this.date = date;
        this.name = name;
        this.address = address;
        this.state = state;
        this.price = price;
    }

    public void setState(int state) {
        this.state = state;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
