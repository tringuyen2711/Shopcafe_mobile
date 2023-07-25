package com.example.shopcafe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shopcafe.database.APPDatabase;

import java.util.ArrayList;
import java.util.List;

public class Checkout extends AppCompatActivity {
    ImageButton goback;
    TextView total_money;
    Button check_out;
    private RecyclerView revCart;
    private List<DrinkCart> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        goback = findViewById(R.id.goback);
        total_money = findViewById(R.id.money_view);
        check_out = findViewById(R.id.checkout);
        revCart = findViewById(R.id.recyclerViewCart);

        list = new ArrayList<>();
        list =APPDatabase.getInstance(this).drinkcartDAO().getListCart();

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,1);
        revCart.setLayoutManager(gridLayoutManager);

        DrinkCartAdapter adapter = new DrinkCartAdapter();
        adapter.setData(list);



        revCart.setAdapter(adapter);

        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        check_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                trackorder temp = new trackorder();
                getSupportFragmentManager().beginTransaction().replace(R.id.checkoutlayout,temp).commit();
            }
        });
    }


}