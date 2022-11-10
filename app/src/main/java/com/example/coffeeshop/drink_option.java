package com.example.coffeeshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.coffeeshop.Adapter.ItemAdapter;
import com.example.coffeeshop.R;

import java.util.ArrayList;

import modal.ItemModel;

public class drink_option extends AppCompatActivity {
        RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item);



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