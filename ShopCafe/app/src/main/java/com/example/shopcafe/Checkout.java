package com.example.shopcafe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
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

public class Checkout extends AppCompatActivity implements DrinkCartAdapter.OnClickCartListener {
    ImageButton goback;
    TextView total_money;
    Button check_out;
    private RecyclerView revCart;
    private List<DrinkCart> list;
    CartViewModel cartViewModel;
    DrinkCartAdapter drinkCartAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        goback = findViewById(R.id.goback);
        total_money = findViewById(R.id.money_view);
        check_out = findViewById(R.id.checkout);
        revCart = findViewById(R.id.recyclerViewCart);

//        list = new ArrayList<>();
//        //list =APPDatabase.getInstance(this).drinkcartDAO().getListCart();

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,1);
        revCart.setLayoutManager(gridLayoutManager);

        cartViewModel = new ViewModelProvider(this).get(CartViewModel.class);
        cartViewModel.getAllCart().observe(this, new Observer<List<DrinkCart>>() {
            @Override
            public void onChanged(List<DrinkCart> drinkCarts) {
                new ItemTouchHelper(simpleCallback).attachToRecyclerView(revCart);
                list = drinkCarts;
                drinkCartAdapter = new DrinkCartAdapter(list,Checkout.this);
                drinkCartAdapter.setData(list);
                revCart.setAdapter(drinkCartAdapter);
            }
        });


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

    ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            DeleteDrink(list.get(viewHolder.getAdapterPosition()));
        }
    };

    @SuppressLint("NotifyDataSetChanged")
    private void DeleteDrink(DrinkCart cartitem)
    {
        list.remove(cartitem);
        cartViewModel.deleteCartItem(cartitem);
        drinkCartAdapter.notifyDataSetChanged();
    }


    @Override
    public void onCartItem(DrinkCart drinkCart) {

    }
}