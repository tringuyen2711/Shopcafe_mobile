package com.example.shopcafe;

import static android.widget.Toast.LENGTH_SHORT;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
    String name1;
    int price1;
    int img1;
    public Drink_child_details() {
        // Required empty public constructor
    }


    public static Drink_child_details newInstance(String name,int img, int price) {
        Drink_child_details fragment = new Drink_child_details();
        Bundle bundle = new Bundle();
        bundle.putString("Name",name);
        bundle.putInt("IMG",img);
        bundle.putInt("Price",price);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        img_cafe = view.findViewById(R.id.image_Americano);
        text_drink = view.findViewById(R.id.text_Americano);
        plus_but = view.findViewById(R.id.plus_button);
        minus_but = view.findViewById(R.id.minux_button);
        dou_shot = view.findViewById(R.id.double_shot);
        sin_shot = view.findViewById(R.id.single_shot);
        bottle_select= view.findViewById(R.id.bottle);
        cup_select = view.findViewById(R.id.cuptea);
        bigsize = view.findViewById(R.id.big_cup);
        midsize= view.findViewById(R.id.mid_cup);
        smallsize= view.findViewById(R.id.small_cup);
        bigice= view.findViewById(R.id.three_ice);
        midice= view.findViewById(R.id.two_ice);
        smallice=view.findViewById(R.id.one_ice);
        sum_money= view.findViewById(R.id.total_amount);
        quanti = view.findViewById(R.id.view_quantity);

        img_cafe.setImageResource(img1);
        text_drink.setText(name1);
        temp_cal = price1;
        sum_money.setText(String.valueOf(temp_cal));
        plus_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantity++;
                quanti.setText(String.valueOf(quantity));
                temp_cal +=  price1 ;
                sum_money.setText(String.valueOf(temp_cal));
            }
        });

        minus_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            if (quantity > 1) {
                quantity--;
                quanti.setText(String.valueOf(quantity));
                temp_cal -= price1;
                sum_money.setText(String.valueOf(temp_cal));
            }
        }});

        sin_shot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            sing_shot = true;
            doub_shot = false;
            clickshot();
            if(size_big)
            {
                temp_cal = price1*quantity + size_L;
            }else if(size_mid){
                temp_cal = price1*quantity + size_M;
            }else {
                temp_cal = price1*quantity;
            }
            sum_money.setText(String.valueOf(temp_cal));
        }});

        dou_shot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            sing_shot = false;
            doub_shot = true;
            clickshot();
            if(size_big)
            {
                temp_cal = price1*quantity + size_L;
            }else if(size_mid){
                temp_cal = price1*quantity + size_M;
            }else {
                temp_cal = price1*quantity;
            }
            temp_cal += doub;
            sum_money.setText(String.valueOf(temp_cal));
        }});

    }
    @SuppressLint("ResourceAsColor")
    public void clickshot() {
        if(sing_shot){
            sin_shot.setBackgroundColor(android.R.color.background_dark);
            dou_shot.setBackgroundColor(android.R.color.background_light);
        }
        else {
            dou_shot.setBackgroundColor(android.R.color.background_dark);
            sin_shot.setBackgroundColor(android.R.color.background_light);
        }
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            price1 = getArguments().getInt("Price");
            name1 = getArguments().getString("Name");
            img1 = getArguments().getInt("IMG");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_drink_child_details, container, false);
        return view;
    }



}

