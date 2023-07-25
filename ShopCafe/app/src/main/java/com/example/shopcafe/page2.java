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

                    getSupportFragmentManager().beginTransaction().replace(R.id.full_paper, Homefragent).commit();
                    return true;
                } else if (itemId == R.id.gift) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.full_paper, Gift).commit();
                    return true;
                } else if (itemId == R.id.order) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.full_paper, Order).commit();
                    return true;
                } else{
                getSupportFragmentManager().beginTransaction().replace(R.id.full_paper, Homefragent).commit();
                return true;
                }
            }
        });

    }
}