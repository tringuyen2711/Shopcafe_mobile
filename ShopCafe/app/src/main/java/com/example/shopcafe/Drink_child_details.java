package com.example.shopcafe;

import static android.widget.Toast.LENGTH_SHORT;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
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

import com.example.shopcafe.database.APPDatabase;


public class Drink_child_details extends Fragment {

    //Declaration
    ImageButton bigsize, midsize, smallsize, bigice, midice, smallice,
            bottle_select, cup_select,plus_but, minus_but, left_arrow;
    DrinkCart drinkCart;
    Button dou_shot, sin_shot,addtocart ;
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
    String name1, shot="", select="", size="", ice="";
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
        left_arrow = view.findViewById(R.id.left_arrow);
        addtocart = view.findViewById(R.id.add_to_cart);

        img_cafe.setImageResource(img1);
        text_drink.setText(name1);
        temp_cal = price1;
        sum_money.setText("$"+String.valueOf(temp_cal)+".00");
        plus_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantity +=1;
                quanti.setText(String.valueOf(quantity));
                temp_cal = getmoney();
                sum_money.setText("$"+String.valueOf(temp_cal)+".00");
            }
        });

        minus_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            if (quantity > 1) {
                quantity -=1;
                quanti.setText(String.valueOf(quantity));
                temp_cal = getmoney();
                sum_money.setText("$"+String.valueOf(temp_cal)+".00");
            }
        }});

        sin_shot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shot = "Single";
                sing_shot = true;
                doub_shot = false;
                clickshot();
                if(size_big)
                {
                    temp_cal = price1*quantity + size_L*quantity;
                }else if(size_mid){
                    temp_cal = price1*quantity + size_M*quantity;
                }else {
                    temp_cal = price1*quantity;
                }
                sum_money.setText("$"+String.valueOf(temp_cal)+".00");
        }});

        dou_shot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shot = "Double";
                sing_shot = false;
                doub_shot = true;
                clickshot();
                if(size_big)
                {
                    temp_cal = price1*quantity + size_L*quantity;
                }else if(size_mid){
                    temp_cal = price1*quantity + size_M*quantity;
                }else {
                    temp_cal = price1*quantity;
                }
                temp_cal = temp_cal+ doub*quantity;
                sum_money.setText("$"+String.valueOf(temp_cal)+".00");
        }});

        cup_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                select="hot";
                select_cup = true;
                select_bot = false;
                select_cup_bot();
        }});

        bottle_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                select ="iced";
                select_cup = false;
                select_bot = true;
                select_cup_bot();
        }});

        bigsize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                size ="big";
                size_big =true;
                size_mid = false;
                size_small = false;
                size_color();
                if(doub_shot)
                {
                    temp_cal = price1*quantity + doub*quantity;
                }else{
                    temp_cal = price1*quantity;
                }
                temp_cal += size_L*quantity;
                sum_money.setText("$"+String.valueOf(temp_cal)+".00");

        }});

        midsize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                size ="medium";
                size_big = false;
                size_mid = true;
                size_small = false;
                size_color();
                if(doub_shot)
                {
                    temp_cal = price1*quantity + doub*quantity;
                }else{
                    temp_cal = price1*quantity;
                }
                temp_cal += size_M*quantity;
                sum_money.setText("$"+String.valueOf(temp_cal)+".00");
        }});

        smallsize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                size ="small";
                size_big = false;
                size_mid = false;
                size_small = true;
                size_color();
                if(doub_shot)
                {
                    temp_cal = price1*quantity + doub*quantity;
                }else{
                    temp_cal = price1*quantity;
                }
                sum_money.setText("$"+String.valueOf(temp_cal)+".00");
        }});

        bigice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ice = "full ice";
                ice_3 = true;
                ice_2 = false;
                ice_1 = false;
                ice_color();
        }});

        midice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ice ="half ice";
                ice_3 = false;
                ice_2 = true;
                ice_1 = false;
                ice_color();
        }});

        smallice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ice = "few ice";
                ice_3 = false;
                ice_2 = false;
                ice_1 = true;
                ice_color();
        }});

        left_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });

        addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drinkCart = new DrinkCart(name1,shot,select,size,ice,quantity,img1,temp_cal);
                APPDatabase.getInstance(getActivity()).drinkcartDAO().insertCart(drinkCart);
                Intent intent = new Intent(getActivity(), Checkout.class);
                startActivity(intent);
            }
        });
    }

    private int getmoney() {
        if(doub_shot && size_big ) return quantity*(price1+doub+size_L);
        if(doub_shot && size_mid) return quantity*(price1+doub+size_M);
        if (!doub_shot &&size_big) return  quantity*(price1+size_L);
        if(!doub_shot && size_mid)return quantity*(price1+size_M);
        if(doub_shot) return quantity*(price1+doub);
        return price1*quantity;
    }



    @SuppressLint("ResourceAsColor")
    private void ice_color() {
        if(ice_3)
        {
            bigice.setBackgroundResource(R.drawable.threeice1);
            smallice.setBackgroundResource(R.drawable.oneice);
            midice.setBackgroundResource(R.drawable.twoice);
        }
        else if(ice_2) {
            bigice.setBackgroundResource(R.drawable.threeice);
            smallice.setBackgroundResource(R.drawable.oneice);
            midice.setBackgroundResource(R.drawable.twoice1);
        }else{
            bigice.setBackgroundResource(R.drawable.threeice);
            smallice.setBackgroundResource(R.drawable.oneice1);
            midice.setBackgroundResource(R.drawable.twoice);
        }
    }

    @SuppressLint("ResourceAsColor")
    private void size_color() {
        if(size_big)
        {
            bigsize.setBackgroundResource(R.drawable.midsize1);
            smallsize.setBackgroundResource(R.drawable.midsize);
            midsize.setBackgroundResource(R.drawable.midsize);
        }
        else if(size_mid) {
            bigsize.setBackgroundResource(R.drawable.midsize);
            midsize.setBackgroundResource(R.drawable.midsize1);
            smallsize.setBackgroundResource(R.drawable.midsize);

        }else{
            bigsize.setBackgroundResource(R.drawable.midsize);
            midsize.setBackgroundResource(R.drawable.midsize);
            smallsize.setBackgroundResource(R.drawable.midsize1);

        }
    }

    @SuppressLint("ResourceAsColor")
    public void select_cup_bot() {
        if(select_cup){
            cup_select.setBackgroundResource(R.drawable.cuptea1);
            bottle_select.setBackgroundResource(R.drawable.bottle);;
        }else{
            cup_select.setBackgroundResource(R.drawable.cuptea);;
            bottle_select.setBackgroundResource(R.drawable.bottle1);;
        }
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

