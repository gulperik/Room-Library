package com.example.roomlibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        List<İtem> items = new ArrayList<İtem>();
        User user = new User();
        Intent intent = getIntent();
        String name = intent.getStringExtra("Name");
        String lastName = intent.getStringExtra("LastName");
        String email = intent.getStringExtra("Email");

        items.add(new İtem(name,lastName,email));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(new MyAdapter(getApplicationContext(),items));


    }
}