package com.example.coffeeshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.coffeeshop.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;


public class Myprofile extends AppCompatActivity {
        FusedLocationProviderClient client;
    Button navb;
    NavigationView nav;
    SupportMapFragment supportMapFragment;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_address);
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
                            Intent intent = new Intent(Myprofile.this, login.class);
                            startActivity(intent);
                            finish();
                            break;
                        case R.id.nav_profile:
                            Intent intent1=new Intent(Myprofile.this, Myprofile.class);
                            startActivity(intent1);
                            finish();
                            break;
                        case R.id.nav_cart:
                            Intent intent2=new Intent(Myprofile.this,cart.class);
                            startActivity(intent2);
                            finish();
                            break;
                        case R.id.nav_home:
                            Intent intent3=new Intent(Myprofile.this,MainActivity2.class);
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

        }
    }