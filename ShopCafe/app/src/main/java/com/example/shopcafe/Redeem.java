package com.example.shopcafe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.shopcafe.database.APPDatabase;

import java.util.ArrayList;
import java.util.List;

public class Redeem extends AppCompatActivity implements Redeem_adapter.OnClickRedeemListener{
    private List<RedeemDrink> redeemDrinks;

    RecyclerView recyclerView;
    Redeem_adapter redeem_adapter;
    redeemViewModel redeemViewModel1;
    OrderViewModel orderViewModel;
    ImageView turnback;

    int sumChangePoints;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redeem);


        recyclerView = findViewById(R.id.revRedeem);
        turnback = findViewById(R.id.back_redeem);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        initdata();

        redeemViewModel1 = new ViewModelProvider(Redeem.this).get(redeemViewModel.class);
        orderViewModel = new ViewModelProvider(Redeem.this).get(OrderViewModel.class);
        redeem_adapter = new Redeem_adapter(redeemDrinks,this);
        recyclerView.setAdapter(redeem_adapter);





        turnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void initdata() {
        if(redeemDrinks == null) {
            redeemDrinks = new ArrayList<>();
            redeemDrinks.add(new RedeemDrink(R.drawable.cafe, "Cafe Latte", "Valid until 04.07.24", 100));
            redeemDrinks.add(new RedeemDrink(R.drawable.flatwhite, "Flat White", "Valid until 04.07.24", 100));
            redeemDrinks.add(new RedeemDrink(R.drawable.capuchino, "Cappuccino", "Valid until 04.07.24", 100));
            redeemDrinks.add(new RedeemDrink(R.drawable.mocha, "Mocha", "Valid until 04.07.24", 100));
        }
    }

    @Override
    public void OnClickRedeem(RedeemDrink redeemDrink) {
        int quantity = orderViewModel.SumOfQuantity();
        int score = quantity *12;
        sumChangePoints =redeemViewModel1.getSumOfQuantity();
        if((score-sumChangePoints) >= redeemDrink.getDrink_points())
        {

            new Thread(() -> {
                APPDatabase.getInstance(this).redeemDrinkDAO().insertDrinkRedeem(redeemDrink);
        }).start();
        }

    }


}