package com.example.coffeeshop;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class drink_option extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drink);


//        ListView listDrinks=getListView();
//
//        ArrayAdapter<Drinks> listAdapter=new ArrayAdapter<Drinks>(
//                this,
//                android.R.layout.simple_list_item_1,
//                Drinks.drinks
//        ) ;
//        listDrinks.setAdapter((listAdapter));
    }
}