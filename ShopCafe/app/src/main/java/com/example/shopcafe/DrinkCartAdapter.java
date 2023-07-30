package com.example.shopcafe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DrinkCartAdapter extends RecyclerView.Adapter<DrinkCartAdapter.CastViewHolder> {

    private List<DrinkCart> LiDrinkCart;
    private OnClickCartListener onClickCartListener;
    public void setData(List<DrinkCart> list )
    {
        this.LiDrinkCart = list;

        notifyDataSetChanged();
    }

    public DrinkCartAdapter(List<DrinkCart> list,OnClickCartListener onClickCartListener) {
        this.onClickCartListener = onClickCartListener;
        this.LiDrinkCart=list;
    }

    @NonNull
    @Override
    public CastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.drinkcart,parent,false);
        return new CastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CastViewHolder holder, int position) {
        DrinkCart drinkcart = LiDrinkCart.get(position);
        if(drinkcart == null) {
            return;
        }
        String detail = drinkcart.getShot()+" | " + drinkcart.getSelect()
                +" | "+ drinkcart.getSize()+" | "+drinkcart.getIce();
        holder.dname.setText(drinkcart.getName());
        holder.ddetail.setText(detail);
        holder.dmoney.setText("$"+String.valueOf(drinkcart.getTotal())+".00");
        holder.dquantity.setText("x"+ drinkcart.getQuantity());
        holder.img.setImageResource(drinkcart.getImg());

        /*holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickCartListener.onCartItem(drinkcart);
            }
        });*/

    }

    @Override
    public int getItemCount() {
        if(LiDrinkCart !=null) return LiDrinkCart.size();
        return 0;
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

    public interface OnClickCartListener {
        public void onCartItem(DrinkCart drinkCart);
    }
}
