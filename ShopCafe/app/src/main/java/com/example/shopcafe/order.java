package com.example.shopcafe;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;


public class order extends Fragment implements orderAdapter.OnClickOrderListener{

    TextView ongoing, history;

    private RecyclerView revOrder;
    private List<OrderItem> listorder;

    OrderViewModel orderViewModel;
    orderAdapter orderadapter;

    public order() {
        // Required empty public constructor
    }


    public static order newInstance() {
        order fragment = new order();

        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ongoing = view.findViewById(R.id.ongoing);
        history = view.findViewById(R.id.history);
        revOrder = view.findViewById(R.id.recyclerOrder);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        revOrder.setLayoutManager(linearLayoutManager);

        orderViewModel = new ViewModelProvider(order.this).get(OrderViewModel.class);

        orderViewModel.getOngoing().observe(getViewLifecycleOwner(), new Observer<List<OrderItem>>() {
            @Override
            public void onChanged(List<OrderItem> list) {
                new ItemTouchHelper(simpleCallback).attachToRecyclerView(revOrder);
                listorder = list;
                orderadapter = new orderAdapter(list,order.this);
                orderadapter.setData(list);
                revOrder.setAdapter(orderadapter);
            }
        });



        ongoing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                orderViewModel.getOngoing().observe(getViewLifecycleOwner(), new Observer<List<OrderItem>>() {
                    @Override
                    public void onChanged(List<OrderItem> list) {
                        new ItemTouchHelper(simpleCallback).attachToRecyclerView(revOrder);
                        listorder = list;
                        orderadapter = new orderAdapter(list,order.this);
                        orderadapter.setData(list);
                        revOrder.setAdapter(orderadapter);
                    }
                });
            }
        });

        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderViewModel.getHistory().observe(getViewLifecycleOwner(), new Observer<List<OrderItem>>() {
                    @Override
                    public void onChanged(List<OrderItem> list) {
                        listorder = list;
                        orderAdapter od = new orderAdapter(list,order.this);
                        od.setData(list);
                        revOrder.setAdapter(od);
                    }
                });
            }
        });

    }

    ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            DeleteOngoing(listorder.get(viewHolder.getAdapterPosition()));
        }
    };

    @SuppressLint("NotifyDataSetChanged")
    private void DeleteOngoing(OrderItem orderItem)
    {
        OrderItem item = orderItem;
        item.setState(0);
        orderViewModel.update(item);
        orderadapter.notifyDataSetChanged();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        BottomNavigationView bt = requireActivity().findViewById(R.id.bottomNavigationView);
        if (bt != null && isAdded()) {

            bt.setVisibility(View.VISIBLE);
        }
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order, container, false);
    }

    @Override
    public void OnclickOrder(OrderItem orderItem)
    {

    }
}