package com.example.coffeeshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.coffeeshop.Adapter.ItemAdapter;
import com.example.coffeeshop.R;

import java.util.ArrayList;

import modal.ItemModel;

public class food_option extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item);

        recyclerView=findViewById(R.id.item_list);

        ArrayList<ItemModel> list=new ArrayList<>();

        list.add(new ItemModel(R.drawable.logo,"Breads","10","0"));
        list.add(new ItemModel(R.drawable.logo,"Cookies","20","0"));
        list.add(new ItemModel(R.drawable.logo,"Brown Bread","20","0"));
        list.add(new ItemModel(R.drawable.logo,"Chips","20","0"));
        list.add(new ItemModel(R.drawable.logo,"Paties","15","0"));
        list.add(new ItemModel(R.drawable.logo,"Roll","40","0"));
        list.add(new ItemModel(R.drawable.logo,"Spring Roll","30","0"));
        list.add(new ItemModel(R.drawable.logo,"Hot Gulab Jamun","15","0"));
        list.add(new ItemModel(R.drawable.logo,"Samosa","12","0"));
        list.add(new ItemModel(R.drawable.logo,"Rasmalai","50","0"));

        ItemAdapter adapter = new ItemAdapter(list,this);
        recyclerView.setAdapter(adapter);

        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager) ;
    }
}