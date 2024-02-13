package com.example.roomlibrary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context context;

    List<İtem> i̇temLists;

    public MyAdapter(Context context, List<İtem> i̇tems) {
        this.context = context;
        this.i̇temLists = i̇tems;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
       holder.firstName.setText(i̇temLists.get(position).getFirstName());
       holder.lastName.setText(i̇temLists.get(position).getLastName());
       holder.email.setText(i̇temLists.get(position).getEmail());

    }

    @Override
    public int getItemCount() {
        return i̇temLists.size();
    }
}
