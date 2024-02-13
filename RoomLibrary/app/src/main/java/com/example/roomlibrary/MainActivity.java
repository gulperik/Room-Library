package com.example.roomlibrary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.sax.RootElement;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.roomlibrary.databinding.ActivityMainBinding;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    List<User> personList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        RoomDatabase.Callback myCallBack = new RoomDatabase.Callback() {
            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                super.onCreate(db);

            }

            @Override
            public void onOpen(@NonNull SupportSQLiteDatabase db) {
                super.onOpen(db);
            }


        };
        AppDatabase UserDB = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "User").addCallback(myCallBack).build();


        binding.Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Executors.newSingleThreadExecutor().execute(new Runnable() {
                    @Override
                    public void run() {
                        String name = binding.editTextText.getText().toString();
                        String lastname = binding.editTextText2.getText().toString();
                        String email = binding.editTextText3.getText().toString();
                        User user = new User(name, lastname, email);

                        UserDB.userDoa().insertAll(user);


                        Log.d("MainActivity", "Save button clicked");
                    }
                });


                Toast.makeText(MainActivity.this, "Hi", Toast.LENGTH_SHORT).show();
            }
        });



        binding.nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Executors.newSingleThreadExecutor().execute(new Runnable() {
                    @Override
                    public void run() {
                        personList = UserDB.userDoa().getAll();
                    }
                });

                if (personList != null && !personList.isEmpty()) {
                    StringBuilder sb = new StringBuilder();
                    StringBuilder sb2 = new StringBuilder();
                    StringBuilder sb3 = new StringBuilder();
                    for (User u : personList) {
                        sb.append(u.getFirstname());
                        sb2.append(u.getLastName());
                        sb3.append(u.getEmail());

                    }
                    String name = sb.toString();
                    String lastname = sb2.toString();
                    String email = sb3.toString();


                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);

                    intent.putExtra("Name", name);
                    intent.putExtra("LastName",lastname);
                    intent.putExtra("Email",email);

                    startActivity(intent);
                }



            }
        });


    }

}






