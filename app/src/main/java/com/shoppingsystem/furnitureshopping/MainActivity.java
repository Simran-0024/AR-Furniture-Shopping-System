package com.shoppingsystem.furnitureshopping; // Replace with your actual package name

import static android.content.ClipData.newIntent;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;


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

    }



}
