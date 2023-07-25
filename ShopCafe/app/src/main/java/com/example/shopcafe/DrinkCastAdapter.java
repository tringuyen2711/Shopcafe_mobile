package com.example.shopcafe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DrinkCastAdapter extends RecyclerView.Adapter<DrinkCastAdapter.CastViewHolder> {

    private List<Drinkcast> LiDrinkCast;

    public void setData(List<Drinkcast> list){
        this.LiDrinkCast=list;
        notifyDataSetChanged();
    }

    public DrinkCastAdapter() {

    }

    @NonNull
    @Override
    public CastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.drinkcast,parent,false);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CastViewHolder holder, int position) {
        final Drinkcast drinkcast = LiDrinkCast.get(position);
        if(drinkcast == null) return;
        String detail = drinkcast.getShot()+"|" + drinkcast.getSelect()
                +drinkcast.getSize()+drinkcast.getIce();
        holder.dname.setText(drinkcast.getName());
        holder.ddetail.setText(detail);
        holder.dmoney.setText(String.valueOf(drinkcast.getTotal()));
        holder.dquantity.setText("x"+String.valueOf(drinkcast.getQuantity()));
        holder.img.setImageResource(drinkcast.getImg());


    }


    public class CastViewHolder extends RecyclerView.ViewHolder{
        private CardView layout_cast;
        private ImageView img;
        private TextView dname,ddetail, dquantity, dmoney;

        public CastViewHolder(@NonNull View itemView) {
            super(itemView);
            layout_cast = itemView.findViewById(R.id.card_drink_cast);
            img = itemView.findViewById(R.id.imageCafecast);
            dname = itemView.findViewById(R.id.castname);
            ddetail = itemView.findViewById(R.id.castDetails);
            dquantity = itemView.findViewById(R.id.castQuantity);
            dmoney = itemView.findViewById(R.id.money);
        }
    }

    @Override
    public int getItemCount() {
        if(LiDrinkCast != null) return LiDrinkCast.size();
        return 0;
    }
}
