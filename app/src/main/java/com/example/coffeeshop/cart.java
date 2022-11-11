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
import android.widget.TextView;
import android.widget.Toast;

import com.example.coffeeshop.Adapter.CartAdapter;
import com.example.coffeeshop.Adapter.ItemAdapter;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import modal.DatabaseModal;
import modal.ItemModel;
import DBhandler.DBCart;

public class cart extends AppCompatActivity {
RecyclerView recyclerView;
    Button navb;
    Button Place_Order;
    TextView Total;
    NavigationView nav;
DBCart db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar);
        View view =getSupportActionBar().getCustomView();

        Place_Order=findViewById(R.id.place_Order);
        Total=findViewById(R.id.total);
        navb=findViewById(R.id.navb);
        nav=findViewById(R.id.nav);
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_logout:
                        Intent intent = new Intent(cart.this, login.class);
                        startActivity(intent);
                        finish();
                        break;
                    case R.id.nav_profile:
                        Intent intent1=new Intent(cart.this, Myprofile.class);
                        startActivity(intent1);
                        finish();
                        break;
                    case R.id.nav_cart:
                        Intent intent2=new Intent(cart.this,cart.class);
                        startActivity(intent2);
                        finish();
                        break;
                    case R.id.nav_home:
                        Intent intent3=new Intent(cart.this,MainActivity2.class);
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
        recyclerView=findViewById(R.id.list);
        db=new DBCart(this);

        ArrayList<DatabaseModal> list=new ArrayList<>();
        list=db.getAllItem();
        int count=0;
        ArrayList<ItemModel> list1=new ArrayList<>();
        for(int i=0;i<list.size();i++)
        {
            ItemModel model = new ItemModel();
            model.setImage(list.get(i).getImage());
            model.setName(list.get(i).getName());
            model.setQuantity(list.get(i).getQuantity());
            model.setPrice(list.get(i).getPrice());
            count+=Integer.parseInt(list.get(i).getPrice().toString())*Integer.parseInt(list.get(i).getQuantity().toString());
            list1.add(model);
        }
        Total.setText("Total Cost: ₹ "+count);
        CartAdapter adapter = new CartAdapter(list1,this);
        recyclerView.setAdapter(adapter);

        GridLayoutManager layoutManager = new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(layoutManager) ;

        Place_Order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(list1.size()>0)
                {
                    Toast.makeText(cart.this, "Order Placed", Toast.LENGTH_SHORT).show();
                    db.deleteAllItem();
                    Intent i=new Intent(cart.this,cart.class);
                    startActivity(i);
                    finish();
                }
                else
                    Toast.makeText(cart.this, "Cart Empty", Toast.LENGTH_SHORT).show();
            }
        });




    }
}