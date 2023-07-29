package com.example.shopcafe;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.shopcafe.database.APPDatabase;


public class Profile_frg extends Fragment {

    private EditText e_name, e_phone, e_email, e_address;
    private ImageButton back;
    private ImageButton bname, bphone, bemail,baddrress;
    private User u1;
    String nameUser;
    private String temp_name, temp_phone, temp_email,temp_address;
    int ID;
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

        init(view);


        e_name.setText(u1.getUsername());
        e_phone.setText(u1.getPhone());
        e_email.setText(u1.getEmail());
        e_address.setText(u1.getAddress());

        bname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e_name.setEnabled(true);
                e_name.requestFocus();
                e_name.setSelection(e_name.getText().length());
                showKeyBoard(e_name);
                e_name.setOnKeyListener(new View.OnKeyListener() {
                    @Override
                    public boolean onKey(View view, int i, KeyEvent keyEvent) {
                        if (i == KeyEvent.KEYCODE_ENTER) {
                            e_name.setEnabled(false);
                            temp_name = e_name.getText().toString();
                            u1.setUsername(temp_name);
                            hideSoftKeyboard(e_name);
                            return true;
                        }
                        return false;
                    }
                });

            }
        });

        bphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e_phone.setEnabled(true);
                e_phone.requestFocus();
                e_phone.setSelection(e_phone.getText().length());
                showKeyBoard(e_phone);
                e_phone.setOnKeyListener(new View.OnKeyListener() {
                    @Override
                    public boolean onKey(View view, int i, KeyEvent keyEvent) {
                        if (i == KeyEvent.KEYCODE_ENTER) {
                            e_phone.setEnabled(false);
                            temp_phone = e_phone.getText().toString();
                            u1.setEmail(temp_phone);
                            hideSoftKeyboard(e_phone);
                            return true;
                        }
                        return false;
                    }
                });
            }
        });

        bemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e_email.setEnabled(true);
                e_email.requestFocus();
                e_email.setSelection(e_email.getText().length());
                showKeyBoard(e_email);
                e_email.setOnKeyListener(new View.OnKeyListener() {
                    @Override
                    public boolean onKey(View view, int i, KeyEvent keyEvent) {
                        if (i == KeyEvent.KEYCODE_ENTER) {
                            e_email.setEnabled(false);
                            temp_email = e_email.getText().toString();
                            u1.setEmail(temp_email);
                            hideSoftKeyboard(e_email);
                            return true;
                        }
                        return false;
                    }
                });

            }
        });

        baddrress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e_address.setEnabled(true);
                e_address.requestFocus();
                e_address.setSelection(e_address.getText().length());
                showKeyBoard(e_address);
                e_address.setOnKeyListener(new View.OnKeyListener() {
                    @Override
                    public boolean onKey(View view, int i, KeyEvent keyEvent) {
                        if (i == KeyEvent.KEYCODE_ENTER) {
                            e_address.setEnabled(false);
                            temp_address = e_address.getText().toString();
                            u1.setEmail(temp_address);
                            hideSoftKeyboard(e_address);
                            return true;
                        }
                        return false;
                    }
                });

            }
        });




        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(()->{
                    APPDatabase.getInstance(getActivity()).userDAO().updateuser(u1);
                }).start();
                hideSoftKeyboard(e_name);
                hideSoftKeyboard(e_address);
                hideSoftKeyboard(e_email);
                hideSoftKeyboard(e_phone);
                getActivity().getSupportFragmentManager().popBackStack("profile", FragmentManager.POP_BACK_STACK_INCLUSIVE);
            }
        });




    }

    private void showKeyBoard(EditText editText) {
        InputMethodManager imm = (InputMethodManager) this.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT);
    }

    private void hideSoftKeyboard(EditText editText) {
        InputMethodManager imm = (InputMethodManager) this.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    private void init(View view) {
        e_name = view.findViewById(R.id.name_edit);

        e_phone = view.findViewById(R.id.phone_edit);

        e_email = view.findViewById(R.id.email_edit);
        e_address = view.findViewById(R.id.address_edit);
        back = view.findViewById(R.id.leftarrowProfile);
        bname = view.findViewById(R.id.buttonName);
        bphone = view.findViewById(R.id.buttonPhone);
        bemail=view.findViewById(R.id.buttonEmail);
        baddrress = view.findViewById(R.id.buttonAddress);

        e_name.setEnabled(false);
        e_phone.setEnabled(false);
        e_email.setEnabled(false);
        e_address.setEnabled(false);

        u1 = APPDatabase.getInstance(getContext()).userDAO().getdata();
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