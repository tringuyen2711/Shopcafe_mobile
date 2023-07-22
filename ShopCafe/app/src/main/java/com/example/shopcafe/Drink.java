package com.example.shopcafe;


public class Drink {

    public static final int TYPE_DRINK = 1;
    public static final int TYPE_CAKE= 2;
    private int image;
    private String name;
    private int type;

    public Drink(int image, String name, int type) {
        this.image = image;
        this.name = name;
        this.type = type;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
