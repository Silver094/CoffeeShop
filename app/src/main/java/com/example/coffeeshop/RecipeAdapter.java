package com.example.coffeeshop;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.ArrayList;
//
//public class RecipeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
//    ArrayList<RecipeModel> list;
//    Context context;
//
//    public RecipeAdapter(ArrayList<RecipeModel> list, Context context) {
//        this.list = list;
//        this.context = context;
//}
//    @NonNull
//    @Override
//    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(context).inflate(R.layout.template,parent,false);
//        return new viewHolder(view);
//    }
//
//
//
//    @Override
//    public int getItemCount() {
//        return list.size();
//    }
//
//    public class viewHolder extends RecyclerView.ViewHolder {
//
//         ImageView image;
//         TextView image_name;
//
//        public viewHolder(@NonNull View itemView) {
//            super(itemView);
//            image = itemView.findViewById(R.id.image);
//            image_name = itemView.findViewById(R.id.image_name);
//        }
//
//    }
//    @Override
//    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
//        RecipeModel model = list.get(position);
////        holder.image.setImageResource(model.getPic());
////        holder.textView.setText(model.getText());
//    }
//
//}
//

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

// Adapter --> displaying the views by extracting the information from the data source

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.viewHolder>{


    ArrayList<RecipeModel> list;
    Context context;

    public RecipeAdapter(ArrayList<RecipeModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.template,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        RecipeModel model = list.get(position);
        holder.imageView.setImageResource(model.getPic());
        holder.textView.setText(model.getText());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            textView = itemView.findViewById(R.id.image_name);
        }
    }

}
