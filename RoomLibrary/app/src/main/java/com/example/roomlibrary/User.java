package com.example.roomlibrary;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")

public class User {


    @PrimaryKey(autoGenerate = true)
     int id;
    @ColumnInfo(name = "first_name")
     String firstname;
    @ColumnInfo(name = "last_name")
    String lastName;
    @ColumnInfo(name = "e_mail")
    String email;

    @Ignore
    public User(){


    }

    public User(String firstname, String lastName, String email) {
        this.firstname = firstname;
        this.lastName = lastName;
        this.email = email;
        this.id = 0;
    }

    public String getFirstname(){return firstname;}
    public String getLastName(){return lastName;}
    public String getEmail(){return email;}


}
