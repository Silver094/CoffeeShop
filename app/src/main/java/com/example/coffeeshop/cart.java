package com.example.coffeeshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.coffeeshop.Adapter.CartAdapter;
import com.example.coffeeshop.Adapter.ItemAdapter;

import java.util.ArrayList;
import java.util.List;

import modal.DatabaseModal;
import modal.ItemModel;
import DBhandler.DBCart;

public class cart extends AppCompatActivity {
RecyclerView recyclerView;
DBCart db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        recyclerView=findViewById(R.id.list);
        db=new DBCart(this);

        ArrayList<DatabaseModal> list=new ArrayList<>();
        list=db.getAllItem();
        ArrayList<ItemModel> list1=new ArrayList<>();
        for(int i=0;i<list.size();i++)
        {
            ItemModel model = new ItemModel();
            model.setImage(list.get(i).getImage());
            model.setName(list.get(i).getName());
            model.setQuantity(list.get(i).getQuantity());
            model.setPrice(list.get(i).getPrice());
            list1.add(model);
        }

        CartAdapter adapter = new CartAdapter(list1,this);
        recyclerView.setAdapter(adapter);

        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager) ;


    }
}