package com.example.shopcafe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.shopcafe.database.APPDatabase;

public class ProFile extends AppCompatActivity {

    private EditText e_name, e_phone, e_email, e_address;
    private ImageButton back;
    private ImageButton bname, bphone, bemail,baddrress;
    private User u1;
    private String temp_name, temp_phone, temp_email,temp_address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro_file);

        init();


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
                    APPDatabase.getInstance(ProFile.this).userDAO().updateuser(u1);
                }).start();
                hideSoftKeyboard(e_name);
                hideSoftKeyboard(e_address);
                hideSoftKeyboard(e_email);
                hideSoftKeyboard(e_phone);
                finish();
            }
        });
    }

    private void showKeyBoard(EditText editText) {
        InputMethodManager imm = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT);
    }

    private void hideSoftKeyboard(EditText editText) {
        InputMethodManager imm = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    private void init() {
        e_name = findViewById(R.id.name_edit);

        e_phone = findViewById(R.id.phone_edit);

        e_email = findViewById(R.id.email_edit);
        e_address = findViewById(R.id.address_edit);
        back = findViewById(R.id.leftarrowProfile);
        bname = findViewById(R.id.buttonName);
        bphone = findViewById(R.id.buttonPhone);
        bemail= findViewById(R.id.buttonEmail);
        baddrress = findViewById(R.id.buttonAddress);

        e_name.setEnabled(false);
        e_phone.setEnabled(false);
        e_email.setEnabled(false);
        e_address.setEnabled(false);

        u1 = APPDatabase.getInstance(this).userDAO().getdata();
    }
}