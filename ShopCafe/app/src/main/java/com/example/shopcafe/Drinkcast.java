package com.example.shopcafe;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "DrinkCast")
public class Drinkcast {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String shot;
    private String select;
    private String size;
    private String ice;

    private int quantity;

    private int img;

    private int total;


    public Drinkcast(String name, String shot, String select, String size, String ice, int quantity, int img, int total) {
        this.name = name;
        this.shot = shot;
        this.select = select;
        this.size = size;
        this.ice = ice;
        this.quantity = quantity;
        this.img = img;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShot() {
        return shot;
    }

    public void setShot(String shot) {
        this.shot = shot;
    }

    public String getSelect() {
        return select;
    }

    public void setSelect(String select) {
        this.select = select;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getIce() {
        return ice;
    }

    public void setIce(String ice) {
        this.ice = ice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
