package com.example.shopcafe;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.shopcafe.database.userDB;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Profile_frg#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Profile_frg extends Fragment {

    private EditText e_name, e_phone, e_email, e_address;

    public Profile_frg() {
        // Required empty public constructor
    }


    public static Profile_frg newInstance() {
        Profile_frg fragment = new Profile_frg();

        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        e_name = view.findViewById(R.id.name_edit);
        e_phone = view.findViewById(R.id.phone_edit);
        e_email = view.findViewById(R.id.email_edit);
        e_address = view.findViewById(R.id.email_edit);

        User u = userDB.getInstance(getContext()).userDAO().getdata();
        e_name.setText(u.getUsername());
        e_phone.setText(u.getPhone());
        e_email.setText(u.getPhone());
        e_address.setText(u.getAddress());
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile_frg, container, false);
    }
}