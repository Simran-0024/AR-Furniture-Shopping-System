package com.shoppingsystem.furnitureshopping; // Replace with your actual package name

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import com.shoppingsystem.furnitureshopping.model.Furniture; // Import your Furniture model
import com.shoppingsystem.furnitureshopping.dao.FurnitureDao; // Import your FurnitureDao interface
import com.shoppingsystem.furnitureshopping.database.FurnitureDatabase; // Import your FurnitureDatabase class

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the database instance and the DAO
        FurnitureDatabase db = FurnitureDatabase.getInstance(this); // Updated to use FurnitureDatabase
        FurnitureDao furnitureDao = db.furnitureDao();

        // Insert sample data
        Furniture chair = new Furniture("Chair", "A comfortable wooden chair", 49.99);
        Furniture table = new Furniture("Table", "A round dining table", 129.99);

        furnitureDao.insert(chair);
        furnitureDao.insert(table);

        // Retrieve and log all furniture items
        List<Furniture> furnitureList = furnitureDao.getAllFurniture();
        for (Furniture furniture : furnitureList) {
            Log.d("MainActivity", "ID: " + furniture.getId() +
                    ", Name: " + furniture.getName() +
                    ", Description: " + furniture.getDescription() +
                    ", Price: " + furniture.getPrice());
        }
    }
}
