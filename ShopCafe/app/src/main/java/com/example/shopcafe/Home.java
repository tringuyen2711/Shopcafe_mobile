package com.example.shopcafe;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class Home extends Fragment {
    TextView greeting_text;
    private RecyclerView revDrink;
    private GridLayoutManager gridLayoutManager;

    public Home(){}

    public static Home newInstance()
    {
        Home fragment = new Home();
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        greeting_text = (TextView) getView().findViewById(R.id.greeting);
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

        revDrink = getView().findViewById(R.id.recyclerDrink);
        gridLayoutManager = new GridLayoutManager(getActivity(),2);
        revDrink.setLayoutManager(gridLayoutManager);

        DrinkApdapter adapter = new DrinkApdapter(getContext(),getlistdrink());
        revDrink.setAdapter(adapter);
        // Inflate the layout for this fragment

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_home, container, false);
    }
    private List<Drink> getlistdrink() {
        List<Drink> list = new ArrayList<>();
        list.add(new Drink(R.drawable.cafe,"Cafe",Drink.TYPE_DRINK, 15));
        list.add(new Drink(R.drawable.capuchino,"Capuchino",Drink.TYPE_DRINK,20));
        list.add(new Drink(R.drawable.mocha,"Mocha",Drink.TYPE_DRINK,30));
        list.add(new Drink(R.drawable.flatwhite,"Flat White",Drink.TYPE_DRINK,35));

        return list;
    }


}