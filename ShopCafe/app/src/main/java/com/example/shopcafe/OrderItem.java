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

    private int quantity;

    public String price;

    public int getState() {
        return state;
    }

    public String getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public OrderItem(String date, String name, String address, int state, String price, int quantity) {
        this.date = date;
        this.name = name;
        this.address = address;
        this.state = state;
        this.price = price;
        this.quantity = quantity;
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
