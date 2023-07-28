package com.example.shopcafe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RewardsAdapter extends RecyclerView.Adapter<RewardsAdapter.RewardsViewHolder>{
    private List<OrderItem> list;

    public RewardsAdapter(List<OrderItem> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RewardsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rewards,parent,false);
        return new RewardsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RewardsViewHolder holder, int position) {
        OrderItem item = list.get(position);
        if(item == null) return;

        holder.name_item.setText(item.getName());
        holder.datetime.setText(item.getDate());
        int default_score =12;
        int total_score = default_score * item.getQuantity();
        holder.rewards_score.setText("+ "+String.valueOf(total_score)+" Pts");
    }

    @Override
    public int getItemCount() {
        if(list != null) return list.size();
        return 0;
    }

    public class RewardsViewHolder extends RecyclerView.ViewHolder{

        private CardView rewardsCard;
        private TextView name_item, datetime, rewards_score;
        public RewardsViewHolder(@NonNull View itemView) {
            super(itemView);

            rewardsCard = itemView.findViewById(R.id.rewards_layout);
            name_item = itemView.findViewById(R.id.name_rewards);
            datetime = itemView.findViewById(R.id.datetime);
            rewards_score = itemView.findViewById(R.id.score_rewards);

        }
    }


}
