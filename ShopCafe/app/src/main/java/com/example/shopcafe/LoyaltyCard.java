package com.example.shopcafe;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shopcafe.database.APPDatabase;

import java.util.ArrayList;
import java.util.List;

public class LoyaltyCard extends Fragment {

    ConstraintLayout cl;
    RecyclerView revLoyalty;
    TextView ndrink;
    List<CupLoyalty> cupLoyalties;
    LoyaltyAdapter adapterLoyal;
    int current_cup;

    public LoyaltyCard() {
        // Required empty public constructor
    }


    public static LoyaltyCard newInstance() {
        LoyaltyCard fragment = new LoyaltyCard();
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cl = view.findViewById(R.id.loyaltycardayout);
        revLoyalty = view.findViewById(R.id.recycler_loyaltycard);
        ndrink = view.findViewById(R.id.ndrink);


        current_cup = (APPDatabase.getInstance(getContext()).orderitemDAO().SumQuantity()) %8;
        ndrink.setText(String.valueOf(current_cup)+"/8");
        for(int i =0; i<8;i++)
        {
            CupLoyalty cupLoyalty = new CupLoyalty(i);
            if(cupLoyalties == null) {
                cupLoyalties = new ArrayList<>();
            }
            cupLoyalties.add(cupLoyalty);
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        revLoyalty.setLayoutManager(linearLayoutManager);

        adapterLoyal = new LoyaltyAdapter();
        adapterLoyal.setData(cupLoyalties,current_cup);
        revLoyalty.setAdapter(adapterLoyal);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onResume() {
        super.onResume();
        current_cup = (APPDatabase.getInstance(getContext()).orderitemDAO().SumQuantity()) %8;
        adapterLoyal.setData(cupLoyalties,current_cup);
        ndrink.setText(String.valueOf(current_cup)+"/8");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        current_cup = (APPDatabase.getInstance(getContext()).orderitemDAO().SumQuantity()) %8;
        adapterLoyal.setData(cupLoyalties,current_cup);
        ndrink.setText(String.valueOf(current_cup)+"/8");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_loyalty_card, container, false);
    }
}