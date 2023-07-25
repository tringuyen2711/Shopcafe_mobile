package com.example.shopcafe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.provider.Settings;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.shopcafe.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class page2 extends AppCompatActivity {

    /*TextView greeting_text;
    private RecyclerView revDrink;
    private GridLayoutManager gridLayoutManager;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page2);

        // set greeting based on current time
        greeting_text = (TextView)findViewById(R.id.greeting);
        Calendar Kalendar = Calendar.getInstance();
        int hours_divide = Kalendar.get(Calendar.HOUR_OF_DAY);
        if(hours_divide >= 6 && hours_divide <12 )
        {
            greeting_text.setText("Good Morning");
        } else if (hours_divide >=12 && hours_divide <18) {
            greeting_text.setText("Good Afternoon");
        }else if (hours_divide >=18 && hours_divide <22) {
            greeting_text.setText("Good Evening");
        }else {
            greeting_text.setText("Good Night");
        }

        revDrink = findViewById(R.id.recyclerDrink);
        gridLayoutManager = new GridLayoutManager(this,2);
        revDrink.setLayoutManager(gridLayoutManager);

        DrinkApdapter adapter = new DrinkApdapter(getlistdrink());
        revDrink.setAdapter(adapter);
    }

    private List<Drink> getlistdrink() {
        List<Drink> list = new ArrayList<>();
        list.add(new Drink(R.drawable.cafe,"Cafe",Drink.TYPE_DRINK));
        list.add(new Drink(R.drawable.capuchino,"Capuchino",Drink.TYPE_DRINK));
        list.add(new Drink(R.drawable.mocha,"Mocha",Drink.TYPE_DRINK));
        list.add(new Drink(R.drawable.flatwhite,"Flat White",Drink.TYPE_DRINK));
        list.add(new Drink(R.drawable.flatwhite,"Flat White",Drink.TYPE_DRINK));
        list.add(new Drink(R.drawable.flatwhite,"Flat White",Drink.TYPE_DRINK));
        return list;
    }*/

    //private ViewPager mViewPaper;
    private BottomNavigationView mBottomNavigationView;
    private Home Homefragent = new Home();
    gift Gift = new gift();
    order Order = new order();
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page2);


        mBottomNavigationView = findViewById(R.id.bottomNavigationView);
        getSupportFragmentManager().beginTransaction().replace(R.id.full_paper, Homefragent).commit();
        
        mBottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.home) {

                    getSupportFragmentManager().beginTransaction().replace(R.id.full_paper, Homefragent).addToBackStack(null).commit();
                    return true;
                } else if (itemId == R.id.gift) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.full_paper, Gift).addToBackStack(null).commit();
                    return true;
                } else if (itemId == R.id.order) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.full_paper, Order).addToBackStack(null).commit();
                    return true;
                } else{
                getSupportFragmentManager().beginTransaction().replace(R.id.full_paper, Homefragent).addToBackStack(null).commit();
                return true;
                }
            }
        });

    }
}