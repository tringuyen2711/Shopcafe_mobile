package com.example.shopcafe;

import static android.widget.Toast.LENGTH_SHORT;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class Drink_child_details extends Fragment {

    //Declaration
    ImageButton bigsize, midsize, smallsize, bigice, midice, smallice,
            bottle_select, cup_select,plus_but, minus_but, left_arrow;

    Button dou_shot, sin_shot ;
    ImageView img_cafe;
    TextView quanti, sum_money, text_drink;
    int quantity =1;
    int size_M=1;
    int size_L= 3;
    int doub = 5;
    boolean sing_shot = false, doub_shot = false, select_cup = false, select_bot = false;
    boolean size_big =false, size_mid=false, size_small = false;
    boolean ice_3 = false, ice_2 = false, ice_1= false;
    int temp_cal= 0;

    private String name;
    private int price;
    private int img;
    public Drink_child_details() {
        // Required empty public constructor
    }


    public static Drink_child_details newInstance(String name,int img, int price) {
        Drink_child_details fragment = new Drink_child_details();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        container.removeAllViews();
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_drink_child_details, container, false);
        return view;
    }



}

