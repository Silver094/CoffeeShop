package com.example.coffeeshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    Button navb;
    NavigationView nav;
    RecyclerView recyclerView;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar);
        View view =getSupportActionBar().getCustomView();




        navb=findViewById(R.id.navb);
        nav=findViewById(R.id.nav);
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent=new Intent(MainActivity2.this,login.class);
                startActivity(intent);
                return false;
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
        recyclerView = findViewById(R.id.list_of_item);

        ArrayList<RecipeModel> list = new ArrayList<>();
        list.add(new RecipeModel(R.drawable.logo,"Beverage"));
        list.add(new RecipeModel(R.drawable.logo,"Eatable"));
        list.add(new RecipeModel(R.drawable.logo,"Others"));


        RecipeAdapter adapter = new RecipeAdapter(list,this);
        recyclerView.setAdapter(adapter);

        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager) ;


        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(
                this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {



            }


        }

}