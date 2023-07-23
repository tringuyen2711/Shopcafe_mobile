package com.example.shopcafe;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DrinkApdapter extends RecyclerView.Adapter<DrinkApdapter.DrinkViewHolder> {
    private List<Drink> liDrink;
    private Context mContext;

    public DrinkApdapter(Context context,List<Drink> liDrink) {
        this.liDrink = liDrink;
        this.mContext=context;
    }

    @NonNull
    @Override
    public DrinkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_drink,parent,false);
        return new DrinkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DrinkViewHolder holder, @SuppressLint("RecyclerView") int position) {
        final Drink drink = liDrink.get(position);
        if(drink ==null)
        {
            return;
        }

        holder.imDrink.setImageResource(drink.getImage());
        holder.tvNameDrink.setText(drink.getName());

        holder.layout_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, Details_Drink.class);
                intent.putExtra("Name", liDrink.get(position).getName());
                intent.putExtra("Price",liDrink.get(position).getPrice());
                intent.putExtra("Img",liDrink.get(position).getPrice());
                mContext.startActivity(intent);
                //Toast.makeText(mContext, "Open" + position, Toast.LENGTH_SHORT).show();
            }
        });

    }



    @Override
    public int getItemCount() {
        if(liDrink != null)
        {
            return liDrink.size();
        }
        return 0;
    }

    // To make our views responsive we can implement onclicklistener
    public class DrinkViewHolder extends RecyclerView.ViewHolder {

        private CardView layout_item;
        //Here we find the views on which we will inflate our data
        private ImageView imDrink;
        private TextView tvNameDrink;

        public DrinkViewHolder(@NonNull View itemView) {
            super(itemView);
            layout_item = itemView.findViewById(R.id.item_card_view);
            imDrink = itemView.findViewById(R.id.drink);
            tvNameDrink = itemView.findViewById(R.id.Text_drink);

        }


    }
}
