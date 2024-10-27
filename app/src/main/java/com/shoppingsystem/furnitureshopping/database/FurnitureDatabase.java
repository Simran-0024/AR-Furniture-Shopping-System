package com.shoppingsystem.furnitureshopping.database; // Replace with your actual package name

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.shoppingsystem.furnitureshopping.model.Furniture; // Import your Furniture model
import com.shoppingsystem.furnitureshopping.dao.FurnitureDao; // Import your FurnitureDao interface

@Database(entities = {Furniture.class}, version = 1)
public abstract class FurnitureDatabase extends RoomDatabase { // Renamed here

    private static FurnitureDatabase instance; // Renamed here

    public abstract FurnitureDao furnitureDao();

    public static synchronized FurnitureDatabase getInstance(Context context) { // Renamed here
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            FurnitureDatabase.class, "furniture_database") // Renamed here
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries() // Use this only for testing; in production, run database operations off the main thread
                    .build();
        }
        return instance;
    }
}
