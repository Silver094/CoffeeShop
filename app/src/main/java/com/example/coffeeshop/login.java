package com.example.coffeeshop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.coffeeshop.helpers.InputValidation;

import DBhandler.DBCart;
import DBhandler.DBhandlerUser;

public class login extends AppCompatActivity {
    Button loginB;
    EditText username,password;
    TextView register;
    DBhandlerUser database;
    InputValidation validate;
    DBCart db;
    LinearLayout LL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db=new DBCart(this);
        db.deleteAllItem();
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar);
        View view =getSupportActionBar().getCustomView();


        loginB=findViewById(R.id.loginButton);
        username=findViewById(R.id.Username);
        password=findViewById(R.id.password);
        register=findViewById(R.id.register);
        LL=findViewById(R.id.view);

        database=new DBhandlerUser(this);
        validate=new InputValidation(this);
        loginB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        verify();

            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(login.this, RegisterActivity.class);
                startActivity(intent);
                finish();

            }
        });

    }
    private void verify() {
        if (!validate.isInputEditTextFilled(username, getString(R.string.error_message_email))) {
            return;
        }
        if (!validate.isInputEditTextEmail(username, getString(R.string.error_message_email))) {
            return;
        }
        if (!validate.isInputEditTextFilled(password, getString(R.string.error_message_email))) {
            return;
        }
        if (database.checkUser(username.getText().toString().trim()
                , password.getText().toString().trim())) {
            Intent move = new Intent(login.this, MainActivity2.class);
//            move.putExtra("EMAIL", username.getText().toString().trim());
            startActivity(move);
            username.setText(null);
            password.setText(null);
        } else {
            Toast.makeText(this, "wrong details", Toast.LENGTH_SHORT).show();
            username.setText(null);
            password.setText(null);

        }
    }
}