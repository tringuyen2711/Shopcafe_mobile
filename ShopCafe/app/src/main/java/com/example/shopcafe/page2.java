package com.example.shopcafe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class page2 extends AppCompatActivity {

    TextView greeting_text;
    private RecyclerView revDrink;
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
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
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
    }

}