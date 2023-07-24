package com.example.shopcafe;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.shopcafe.database.userDB;


public class Profile_frg extends Fragment {

    private EditText e_name, e_phone, e_email, e_address;
    private ImageButton back;
    String nameUser;
    int ID;
    public Profile_frg() {
        // Required empty public constructor
    }


    public static Profile_frg newInstance(String user_name, int ID) {
        Bundle args = new Bundle();
        args.putString("usname", user_name);
        args.putInt("ID",ID);
        Profile_frg fragment = new Profile_frg();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        e_name = view.findViewById(R.id.name_edit);
        e_phone = view.findViewById(R.id.phone_edit);
        e_email = view.findViewById(R.id.email_edit);
        e_address = view.findViewById(R.id.address_edit);
        back = view.findViewById(R.id.leftarrowProfile);


        User u = userDB.getInstance(getContext()).userDAO().findByName(nameUser);
        ID = u.getId();
        e_name.setText(u.getUsername());
        e_phone.setText(u.getPhone());
        e_email.setText(u.getEmail());
        e_address.setText(u.getAddress());

        String temp_name = e_name.getText().toString();
        String temp_phone = e_phone.getText().toString();
        String temp_email = e_email.getText().toString();
        String temp_address = e_address.getText().toString();

        u.setId(ID);
        u.setUsername(temp_name);
        u.setAddress(temp_address);
        u.setPhone(temp_phone);
        u.setEmail(temp_email);

        userDB.getInstance(getActivity()).userDAO().updateuser(u);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });




    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!= null){
            nameUser = getArguments().getString("usname");
            ID = getArguments().getInt("ID");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile_frg, container, false);
    }
}