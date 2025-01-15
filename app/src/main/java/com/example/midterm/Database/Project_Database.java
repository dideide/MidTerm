package com.example.midterm.Database;


import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.carrentalapp.Model.Customer;

import retrofit2.Converter;

@Database(entities = {Customer.class,       }, version = 1)

@TypeConverters({Converter.class})
public abstract class Project_Database extends RoomDatabase {
    public abstract CustomerDao customerDao();
}

