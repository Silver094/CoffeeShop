package com.example.coffeeshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.coffeeshop.Adapter.ItemAdapter;
import com.example.coffeeshop.R;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import modal.ItemModel;

public class drink_option extends AppCompatActivity {
        RecyclerView recyclerView;
    Button navb;
    NavigationView nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar);
        View view =getSupportActionBar().getCustomView();

        navb=findViewById(R.id.navb);
        nav=findViewById(R.id.nav);
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_logout:
                        Intent intent = new Intent(drink_option.this, login.class);
                        startActivity(intent);
                        finish();
                        break;
                    case R.id.nav_profile:
                        Intent intent1=new Intent(drink_option.this, Myprofile.class);
                        startActivity(intent1);
                        finish();
                        break;
                    case R.id.nav_cart:
                        Intent intent2=new Intent(drink_option.this,cart.class);
                        startActivity(intent2);
                        finish();
                        break;
                    case R.id.nav_home:
                        Intent intent3=new Intent(drink_option.this,MainActivity2.class);
                        startActivity(intent3);
                        finish();
                        break;
                }
                return true;
            }

        });

        navb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nav.getVisibility()==View.INVISIBLE)
                {
                    nav.setVisibility(View.VISIBLE);
                    navb.setText("→");
                }
                else {
                    nav.setVisibility(View.INVISIBLE);
                    navb.setText("≡");
                }
            }
        });

        recyclerView=findViewById(R.id.item_list);
        ArrayList<ItemModel> list=new ArrayList<>();
        list.add(new ItemModel(R.drawable.logo,"Capachino","50","0"));
        list.add(new ItemModel(R.drawable.logo,"Latte","50","0"));
        list.add(new ItemModel(R.drawable.logo,"Americano","50","0"));
        list.add(new ItemModel(R.drawable.logo,"Cortado","50","0"));
        list.add(new ItemModel(R.drawable.logo,"Mocha","50","0"));
        list.add(new ItemModel(R.drawable.logo,"Macchiato","50","0"));
        list.add(new ItemModel(R.drawable.logo,"Flat White","50","0"));
        list.add(new ItemModel(R.drawable.logo,"Decaf","50","0"));
        list.add(new ItemModel(R.drawable.logo,"Irish Coffee","50","0"));

        ItemAdapter adapter = new ItemAdapter(list,this);
        recyclerView.setAdapter(adapter);

        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager) ;




    }
}