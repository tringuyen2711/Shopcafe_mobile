package com.example.shopcafe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DrinkApdapter extends RecyclerView.Adapter<DrinkApdapter.DrinkViewHolder> {
    private List<Drink> liDrink;

    public DrinkApdapter(List<Drink> liDrink) {
        this.liDrink = liDrink;
    }

    @NonNull
    @Override
    public DrinkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_drink,parent,false);
        return new DrinkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DrinkViewHolder holder, int position) {
        Drink drink = liDrink.get(position);
        if(drink ==null)
        {
            return;
        }

        holder.imDrink.setImageResource(drink.getImage());
        holder.tvNameDrink.setText(drink.getName());
    }

    @Override
    public int getItemCount() {
        if(liDrink != null)
        {
            return liDrink.size();
        }
        return 0;
    }

    public class DrinkViewHolder extends RecyclerView.ViewHolder {

        private ImageView imDrink;
        private TextView tvNameDrink;

        public DrinkViewHolder(@NonNull View itemView) {
            super(itemView);

            imDrink = itemView.findViewById(R.id.drink);
            tvNameDrink = itemView.findViewById(R.id.Text_drink);
        }
    }
}
