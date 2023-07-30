package com.example.shopcafe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopcafe.database.APPDatabase;

import java.util.List;

public class LoyaltyAdapter extends RecyclerView.Adapter<LoyaltyAdapter.LoyaltyViewHolder>{

    List<CupLoyalty> i_cup;
    int current_cup;

    public void setData(List<CupLoyalty> i_cup, int current_cup)
    {
        this.i_cup = i_cup;
        this.current_cup = current_cup;
        notifyDataSetChanged();
    }

    public LoyaltyAdapter() {
    }

    @NonNull
    @Override
    public LoyaltyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cup, parent,false);
        return new LoyaltyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LoyaltyViewHolder holder, int position) {
        CupLoyalty loyaltyCard = i_cup.get(position);
        if(loyaltyCard == null) return;

        if(position < current_cup)
        {
            holder.img.setImageResource(R.drawable.loyaltycup1);
        }else{
            holder.img.setImageResource(R.drawable.loyaltycup);
        }

    }

    @Override
    public int getItemCount() {
        if (i_cup != null) return i_cup.size();
        return 0;
    }

    public class LoyaltyViewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        public LoyaltyViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.cupLoyalty);
        }
    }
}
