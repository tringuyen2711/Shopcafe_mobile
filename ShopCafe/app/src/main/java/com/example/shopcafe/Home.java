package com.example.shopcafe;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.shopcafe.database.APPDatabase;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class Home extends Fragment implements DrinkApdapter.OnClickItemListener {
    TextView greeting_text, uname;
    private RecyclerView revDrink;
    List<Drink> list ;

    ImageButton profile, cart;
    private User user1;
    private GridLayoutManager gridLayoutManager;
    String usname;
    private int id;
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
        uname = (TextView) getView().findViewById(R.id.name_user);
        profile = (ImageButton) getView().findViewById(R.id.profile);
        cart = getView().findViewById(R.id.buy);

        check_insert();
        uname.setText(APPDatabase.getInstance(getContext()).userDAO().getdata().getUsername());

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

        DrinkApdapter adapter = new DrinkApdapter(getlistdrink(), this);
        revDrink.setAdapter(adapter);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Fragment frag = Profile_frg.newInstance();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.home_frag,frag).addToBackStack("profile").commit();*/
                Intent intent = new Intent(getActivity(), ProFile.class);
                startActivity(intent);
            }
        });

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Checkout.class);
                startActivity(intent);
            }
        });
        // Inflate the layout for this fragment

    }
    private void check_insert() {
        if(APPDatabase.getInstance(getActivity()).userDAO().getdata() == null)
        {
            String name = "Anderson";
            String phone = "+60134589525";
            String email = "Anderson@gmail.com";
            String address = "3 Addersion Court Chino Hills, HO56824, United State";
            user1 = new User(name,address,phone,email);
            APPDatabase.getInstance(getActivity()).userDAO().insertuser(user1);
        }
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LoyaltyCard loyaltyCard = new LoyaltyCard();
        requireActivity().getSupportFragmentManager().beginTransaction().add(R.id.loyalty_card_layout,loyaltyCard).commit();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        check_insert();
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
    private List<Drink> getlistdrink() {
        if(list == null) {
            list = new ArrayList<>();
            list.add(new Drink(R.drawable.cafe, "Cafe", Drink.TYPE_DRINK, 15));
            list.add(new Drink(R.drawable.capuchino, "Capuchino", Drink.TYPE_DRINK, 20));
            list.add(new Drink(R.drawable.mocha, "Mocha", Drink.TYPE_DRINK, 30));
            list.add(new Drink(R.drawable.flatwhite, "Flat White", Drink.TYPE_DRINK, 35));
        }
        return list;
    }

    @Override
    public void onStart() {

        super.onStart();

    }

    @Override
    public void onResume() {
        super.onResume();
        uname.setText(APPDatabase.getInstance(getContext()).userDAO().getdata().getUsername());

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void ClickItem(Drink drink_items) {
        Fragment fragment = Drink_child_details.newInstance(drink_items.getName(), drink_items.getImage(),
                drink_items.getPrice());
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.home_frag,fragment).addToBackStack("details").commit();
    }
}