package com.example.shopcafe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Calendar;
import java.util.List;

public class Redeem_adapter extends RecyclerView.Adapter<Redeem_adapter.RedeemViewHolder>{

    private List<RedeemDrink> redeemDrinkList;
    private OnClickRedeemListener onClickRedeemListener;

    public Redeem_adapter(List<RedeemDrink> redeemDrinkList, OnClickRedeemListener onClickRedeemListener) {
        this.redeemDrinkList = redeemDrinkList;
        this.onClickRedeemListener = onClickRedeemListener;
    }

    @NonNull
    @Override
    public RedeemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_redeem,parent,false);
        return new RedeemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RedeemViewHolder holder, int position) {
        RedeemDrink redeemDrink = redeemDrinkList.get(position);
        if(redeemDrink == null) return;

        holder.img.setImageResource(redeemDrink.getImg());
        holder.name.setText(redeemDrink.getName());
        holder.point_redeem.setText(String.valueOf(redeemDrink.getDrink_points()) + " pts");
        holder.date.setText(redeemDrink.getDatetime());

        holder.point_redeem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickRedeemListener.OnClickRedeem(redeemDrink);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(redeemDrinkList != null) return redeemDrinkList.size();
        return 0;
    }

    public class RedeemViewHolder extends RecyclerView.ViewHolder{
        private CardView redeemCardView;
        private TextView name, date, point_redeem;
        private ImageView img;
        public RedeemViewHolder(@NonNull View itemView) {
            super(itemView);

            redeemCardView = itemView.findViewById(R.id.redeem_layout);
            name = itemView.findViewById(R.id.name_redeem);
            date = itemView.findViewById(R.id.date_redeem);
            img = itemView.findViewById(R.id.img_redeem);
            point_redeem = itemView.findViewById(R.id.Points_redeem);
        }
    }

    public interface OnClickRedeemListener{
        void OnClickRedeem(RedeemDrink redeemDrink);
    }
}
