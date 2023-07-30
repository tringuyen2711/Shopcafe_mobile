package com.example.shopcafe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class orderAdapter extends RecyclerView.Adapter<orderAdapter.OrderViewHolder> {

    private List<OrderItem> liorder;
    private OnClickOrderListener onClickOrderListener;

    public void setData(List<OrderItem> list)
    {
        this.liorder = list;
        notifyDataSetChanged();
    }
    public orderAdapter(List<OrderItem> liorder, OnClickOrderListener onClickOrderListener) {
        this.liorder = liorder;
        this.onClickOrderListener = onClickOrderListener;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_order, parent,false);
        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        OrderItem orderItem = liorder.get(position);
        if(orderItem== null) return;

        holder.name.setText(orderItem.getName());
        holder.date_time.setText(orderItem.getDate());
        holder.money_order.setText("$"+orderItem.getPrice()+".00");
        holder.address_order.setText(orderItem.getAddress());
    }

    @Override
    public int getItemCount() {
        if(liorder != null ) return liorder.size();
        return 0;
    }

    public class OrderViewHolder extends RecyclerView.ViewHolder{

        private CardView layout_order;

        private TextView name, date_time, address_order, money_order;

        public OrderViewHolder(@NonNull View itemView){
            super(itemView);

            layout_order = itemView.findViewById(R.id.order_card);
            name = itemView.findViewById(R.id.name_order);
            address_order = itemView.findViewById(R.id.address_order);
            date_time = itemView.findViewById(R.id.date_order);
            money_order = itemView.findViewById(R.id.money_order);
        }
    }

    public interface OnClickOrderListener{
        public void OnclickOrder(OrderItem orderItem);
    }
}
