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

import com.example.coffeeshop.R;
import com.example.coffeeshop.helpers.InputValidation;

import DBhandler.DBhandlerUser;
import modal.User;

public class RegisterActivity extends AppCompatActivity {
    Button register;
    EditText Uname,NewUsername,pass,Cpass;
    TextView login;
    LinearLayout LL;
    InputValidation validate;
    DBhandlerUser database;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        
        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar);
        View view =getSupportActionBar().getCustomView();

        register=findViewById(R.id.register);
        Uname=findViewById(R.id.name);
        NewUsername=findViewById(R.id.NewUsername);
        login=findViewById(R.id.login);

        getSupportActionBar().hide();
        pass=findViewById(R.id.pass);
        Cpass=findViewById(R.id.Cpass);


        validate=new InputValidation(this);
        database=new DBhandlerUser(this);
        user=new User();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updatedatabase();
                Intent intent=new Intent(RegisterActivity.this,login.class);
                startActivity(intent);
                finish();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(RegisterActivity.this,login.class);
                startActivity(intent);
                finish();
            }
        });



    }
    private void updatedatabase()
    {
        if (!validate.isInputEditTextFilled(Uname, getString(R.string.error_message_name))) {
            return;
        }
        if (!validate.isInputEditTextFilled(NewUsername, getString(R.string.error_message_email))) {
            return;
        }
        if (!validate.isInputEditTextEmail(NewUsername, getString(R.string.error_message_email))) {
            return;
        }
        if (!validate.isInputEditTextFilled(pass, getString(R.string.error_message_password))) {
            return;
        }
        if (!validate.isInputEditTextMatches(pass, Cpass,
                getString(R.string.error_password_matcxh))) {
            return;
        }

        if (!database.checkUser(NewUsername.getText().toString().trim())) {

            user.setName(Uname.getText().toString().trim());
            user.setEmail(NewUsername.getText().toString().trim());
            user.setPassword(pass.getText().toString().trim());

            database.addUser(user);

            // Snack Bar to show success message that record saved successfully
            Toast.makeText(this, "Successfully Registerd", Toast.LENGTH_SHORT).show();
            Uname.setText(null);
            NewUsername.setText(null);
            pass.setText(null);
            Cpass.setText(null);



        } else {
            // Snack Bar to show error message that record already exists
            Toast.makeText(this, "User Already Exist", Toast.LENGTH_SHORT).show();

        }
    }
}