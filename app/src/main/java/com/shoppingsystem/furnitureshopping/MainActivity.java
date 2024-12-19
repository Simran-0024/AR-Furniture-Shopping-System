package com.shoppingsystem.furnitureshopping; // Replace with your actual package name

import static android.content.ClipData.newIntent;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import com.shoppingsystem.furnitureshopping.model.Furniture; // Import your Furniture model
import com.shoppingsystem.furnitureshopping.dao.FurnitureDao; // Import your FurnitureDao interface
import com.shoppingsystem.furnitureshopping.database.FurnitureDatabase; // Import your FurnitureDatabase class

public class MainActivity extends AppCompatActivity {
    EditText username;
    EditText password;
    Button loginButton ;
    TextView signUp;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        loginButton=findViewById(R.id.loginButton);
        signUp = findViewById(R.id.signUp);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.getText().toString().equals("simian") && password.getText().toString().equals("1234")){
                    Toast.makeText(MainActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();

                } else{
                    Toast.makeText(MainActivity.this, "Login Failed!", Toast.LENGTH_SHORT).show();
                }

            }


        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (getApplicationContext(),MainActivity2.class);
                startActivity(intent);

            }
        });







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
