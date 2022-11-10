package com.example.coffeeshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.coffeeshop.Adapter.RecipeAdapter;
import com.example.coffeeshop.Adapter.recomendedAdapter;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import modal.ItemModel;
import modal.RecipeModel;

public class MainActivity2 extends AppCompatActivity {

    Button navb;
    NavigationView nav;
    RecyclerView recyclerView,recyclerView1;
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
                switch (item.getItemId()) {
                    case R.id.nav_logout:
                        Intent intent = new Intent(MainActivity2.this, login.class);
                        startActivity(intent);
                        finish();
                        break;
                    case R.id.nav_profile:
                        Intent intent1=new Intent(MainActivity2.this, Myprofile.class);
                        startActivity(intent1);
                        break;
                    case R.id.nav_cart:
                        Intent intent2=new Intent(MainActivity2.this,cart.class);
                        startActivity(intent2);
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
        recyclerView = findViewById(R.id.list_of_item);

        ArrayList<RecipeModel> list = new ArrayList<>();
        list.add(new RecipeModel(R.drawable.logo,"Beverage"));
        list.add(new RecipeModel(R.drawable.logo,"Eatable"));

        RecipeAdapter adapter = new RecipeAdapter(list,this);
        recyclerView.setAdapter(adapter);

        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager) ;


        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(
                this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                switch(position){
                    case 0:
                        // Intent is used to switch activity
                       Intent intent=new Intent(MainActivity2.this,drink_option.class);
                       startActivity(intent);
                        break;
                    case 1:
                        Intent in=new Intent(MainActivity2.this,food_option.class);
                        startActivity(in);
                        break;

                    default:


            }


        }
        }
        ));
        recyclerView1=findViewById(R.id.recyclerView);
        ArrayList<ItemModel> list1=new ArrayList<>();

        list1.add(new ItemModel(R.drawable.logo,"Capachino","50","0"));
        list1.add(new ItemModel(R.drawable.logo,"Latte","50","0"));
        list1.add(new ItemModel(R.drawable.logo,"Americano","50","0"));
        list1.add(new ItemModel(R.drawable.logo,"Cortado","50","0"));
        list1.add(new ItemModel(R.drawable.logo,"Mocha","50","0"));
        list1.add(new ItemModel(R.drawable.logo,"Macchiato","50","0"));
        list1.add(new ItemModel(R.drawable.logo,"Flat White","50","0"));
        list1.add(new ItemModel(R.drawable.logo,"Decaf","50","0"));
        list1.add(new ItemModel(R.drawable.logo,"Irish Coffee","50","0"));

        recomendedAdapter adapter1 = new recomendedAdapter(list1,this);
        recyclerView1.setAdapter(adapter1);

        StaggeredGridLayoutManager layoutManager1 = new StaggeredGridLayoutManager(1,LinearLayoutManager.HORIZONTAL);
        recyclerView1.setLayoutManager(layoutManager1) ;

    }
}