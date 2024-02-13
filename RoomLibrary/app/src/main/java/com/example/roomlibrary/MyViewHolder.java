package com.example.roomlibrary;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView firstName;
    TextView lastName;
    TextView email;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        firstName = itemView.findViewById(R.id.ItemName);
        lastName = itemView.findViewById(R.id.ItemLastName);
        email = itemView.findViewById(R.id.ItemEmail);

    }
}
