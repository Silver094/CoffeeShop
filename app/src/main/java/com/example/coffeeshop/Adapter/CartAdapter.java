package com.example.coffeeshop.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coffeeshop.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import DBhandler.DBCart;
import modal.DatabaseModal;
import modal.ItemModel;

public class CartAdapter extends RecyclerView.Adapter<com.example.coffeeshop.Adapter.CartAdapter.viewholder>{

        ArrayList<ItemModel> list;
        List<DatabaseModal> arr;
        Context context;
        DBCart db;
        DatabaseModal dm;
        public CartAdapter(ArrayList<ItemModel> list, Context context) {
            this.list = list;
            this.context = context;
        }

        @NonNull
        @Override
        public com.example.coffeeshop.Adapter.CartAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.order_template,parent,false);
            return new com.example.coffeeshop.Adapter.CartAdapter.viewholder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull com.example.coffeeshop.Adapter.CartAdapter.viewholder holder, int position) {

            final ItemModel model = list.get(position);
            holder.item_image.setImageResource(model.getImage());
            holder.image_name.setText(model.getName());
            holder.price.setText(model.getPrice());
            holder.quantity.setText(model.getQuantity());
            dm=new DatabaseModal();
            db=new DBCart(context);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int a=Integer.parseInt(holder.quantity.getText().toString());
                    a++;
                    holder.quantity.setText(a+"");
                    dm.setPrice(holder.price.getText().toString());
                    dm.setName(holder.image_name.getText().toString());
                    dm.setQuantity(holder.quantity.getText().toString());
                    dm.setImage(model.getImage());
                    db.addItem(dm);
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    int a=Integer.parseInt(holder.quantity.getText().toString());
                    a--;
                    holder.quantity.setText(a+"");
                    Toast.makeText(context, "Removed from Cart", Toast.LENGTH_SHORT).show();
                    return true;
                }

            });
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class viewholder extends RecyclerView.ViewHolder {

            ImageView item_image;
            TextView image_name,price,quantity;
            FloatingActionButton add;

            public viewholder(@NonNull View itemView) {
                super(itemView);
                item_image = itemView.findViewById(R.id.item_image);
                image_name = itemView.findViewById(R.id.image_name);
                price = itemView.findViewById(R.id.price);
                quantity=itemView.findViewById(R.id.quantity);
                add=itemView.findViewById(R.id.floatingActionButton);

            }
        }

    }


