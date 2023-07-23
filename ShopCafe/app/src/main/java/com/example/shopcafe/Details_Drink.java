package com.example.shopcafe;

import static android.widget.Toast.LENGTH_SHORT;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Details_Drink extends AppCompatActivity {
    ImageButton bigsize, midsize, smallsize, bigice, midice, smallice,
            bottle_select, cup_select,plus_but, minus_but, left_arrow;

    Button dou_shot, sin_shot ;
    ImageView img_cafe;
    TextView quanti, sum_money, text_drink;
    int quantity =1;
    int price = 0;
    int size_M=1;
    int size_L= 3;
    int doub = 5;
    boolean sing_shot = false, doub_shot = false, select_cup = false, select_bot = false;
    boolean size_big =false, size_mid=false, size_small = false;
    boolean ice_3 = false, ice_2 = false, ice_1= false;
    int temp_cal= 0;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_drink);

        Bundle bundle = getIntent().getExtras();
        if(bundle == null){
            return;
        }

        //caught activity and get data
        Intent intent = getIntent();
        price = intent.getExtras().getInt("Price");
        temp_cal=intent.getExtras().getInt("Price");

        img_cafe = findViewById(R.id.image_Americano);
        text_drink = findViewById(R.id.text_Americano);
        plus_but = (ImageButton) findViewById(R.id.plus_button);
        minus_but = findViewById(R.id.minux_button);
        dou_shot = findViewById(R.id.double_shot);
        sin_shot = findViewById(R.id.single_shot);
        bottle_select= findViewById(R.id.bottle);
        cup_select = findViewById(R.id.cuptea);
        bigsize = findViewById(R.id.big_cup);
        midsize= findViewById(R.id.mid_cup);
        smallsize= findViewById(R.id.small_cup);
        bigice= findViewById(R.id.three_ice);
        midice= findViewById(R.id.two_ice);
        smallice=findViewById(R.id.one_ice);
        sum_money= findViewById(R.id.total_amount);
        quanti = findViewById(R.id.view_quantity);
        sum_money.setText(String.valueOf(temp_cal));

        String name = intent.getExtras().getString("Name");
        text_drink.setText(name);
        int img = intent.getExtras().getInt("Img");
        img_cafe.setImageResource(img);

        plus_but.setOnClickListener(view -> {
            quantity++;
            quanti.setText(String.valueOf(quantity));
            temp_cal +=  price ;
            sum_money.setText(String.valueOf(temp_cal));
        });

        minus_but.setOnClickListener(view -> {
            if (quantity < 1) {
                Toast toast = Toast.makeText(Details_Drink.this,"Can not minus (it is 1)", LENGTH_SHORT);
                toast.setGravity(Gravity.TOP | Gravity.CENTER, 20, 30);
                toast.show();
            } else {
                quantity--;
                quanti.setText(String.valueOf(quantity));
                temp_cal -= price;
                sum_money.setText(String.valueOf(temp_cal));
            }
        });

        sin_shot.setOnClickListener(view -> {
            sing_shot = true;
            doub_shot = false;
            clickshot();
            if(size_big)
            {
                temp_cal = price*quantity + size_L;
            }else if(size_mid){
                temp_cal = price*quantity + size_M;
            }else {
                temp_cal = price*quantity;
            }
            sum_money.setText(String.valueOf(temp_cal));
        });

        dou_shot.setOnClickListener(view -> {
            sing_shot = false;
            doub_shot = true;
            clickshot();
            if(size_big)
            {
                temp_cal = price*quantity + size_L;
            }else if(size_mid){
                temp_cal = price*quantity + size_M;
            }else {
                temp_cal = price*quantity;
            }
            temp_cal += doub;
            sum_money.setText(String.valueOf(temp_cal));
        });

        cup_select.setOnClickListener(view -> {
            select_cup = true;
            select_bot = false;
            select_cup_bot();
        });

        bottle_select.setOnClickListener(view -> {
            select_cup = false;
            select_bot = true;
            select_cup_bot();
        });

        bigsize.setOnClickListener(view -> {
            size_big = true;
            size_mid = false;
            size_small = false;
            size_color();
            if(doub_shot)
            {
                temp_cal = price*quantity + doub;
            }else{
                temp_cal = price*quantity;
            }
            temp_cal += size_L;
            sum_money.setText(String.valueOf(temp_cal));

        });

        midsize.setOnClickListener(view -> {
            size_big = false;
            size_mid = true;
            size_small = false;
            size_color();
            if(doub_shot)
            {
                temp_cal = price*quantity + doub;
            }else{
                temp_cal = price*quantity;
            }
            temp_cal += size_M;
            sum_money.setText(String.valueOf(temp_cal));

        });

        smallsize.setOnClickListener(view -> {
            size_big = false;
            size_mid = false;
            size_small = true;
            size_color();
            if(doub_shot)
            {
                temp_cal = price*quantity + doub;
            }else{
                temp_cal = price*quantity;
            }
            sum_money.setText(String.valueOf(temp_cal));
        });

        bigice.setOnClickListener(view -> {
            ice_3 = true;
            ice_2 = false;
            ice_1 = false;
            ice_color();
        });

        midice.setOnClickListener(view -> {
            ice_3 = false;
            ice_2 = true;
            ice_1 = false;
            ice_color();
        });

        smallice.setOnClickListener(view -> {
            ice_3 = false;
            ice_2 = false;
            ice_1 = true;
            ice_color();
        }

        );

        left_arrow.setOnClickListener(view -> finish());
    }

    @SuppressLint("ResourceAsColor")
    private void ice_color() {
        if(ice_3)
        {
            bigice.setBackgroundColor(android.R.color.background_dark);
            smallice.setBackgroundColor(android.R.color.background_light);
            midice.setBackgroundColor(android.R.color.background_light);
        }
        else if(ice_2) {
            bigice.setBackgroundColor(android.R.color.background_light);
            smallice.setBackgroundColor(android.R.color.background_light);
            midice.setBackgroundColor(android.R.color.background_dark);
        }else{
            bigice.setBackgroundColor(android.R.color.background_light);
            smallice.setBackgroundColor(android.R.color.background_dark);
            midice.setBackgroundColor(android.R.color.background_light);
        }
    }

    @SuppressLint("ResourceAsColor")
    private void size_color() {
        if(size_big)
        {
            bigsize.setBackgroundColor(android.R.color.background_dark);
            smallsize.setBackgroundColor(android.R.color.background_light);
            midsize.setBackgroundColor(android.R.color.background_light);
        }
        else if(size_mid) {
            bigsize.setBackgroundColor(android.R.color.background_light);
            smallsize.setBackgroundColor(android.R.color.background_light);
            midsize.setBackgroundColor(android.R.color.background_dark);
        }else{
            bigsize.setBackgroundColor(android.R.color.background_light);
            smallsize.setBackgroundColor(android.R.color.background_dark);
            midsize.setBackgroundColor(android.R.color.background_light);
        }
    }

    @SuppressLint("ResourceAsColor")
    private void select_cup_bot() {
        if(select_cup){
            cup_select.setBackgroundColor(android.R.color.background_dark);
            bottle_select.setBackgroundColor(android.R.color.background_light);
        }else{
            cup_select.setBackgroundColor(android.R.color.background_light);
            bottle_select.setBackgroundColor(android.R.color.background_dark);
        }
    }

    // change state of 2 shot : single, double
    @SuppressLint("ResourceAsColor")
    private void clickshot() {
        if(sing_shot){
            sin_shot.setBackgroundColor(android.R.color.background_dark);
            dou_shot.setBackgroundColor(android.R.color.background_light);
        }
        else {
            dou_shot.setBackgroundColor(android.R.color.background_dark);
            sin_shot.setBackgroundColor(android.R.color.background_light);
        }
    }
}
