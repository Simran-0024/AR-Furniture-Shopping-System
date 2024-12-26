package com.shoppingsystem.furnitureshopping;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

public class database extends AppCompatActivity{
    EditText target1, target2;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        target1=findViewById(R.id.target1);
        target2=findViewById(R.id.target2);
        b1=findViewById(R.id.b1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new bgthread().start();
            }
        });
    }

    class bgthread extends Thread{

        public void run(){
            super.run();

            AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                    AppDatabase.class, "room_db").build();
            UserDao userDao = db.userDao();
            userDao.insertRecord(new User(1, target1.getText().toString(), target2.getText().toString()));
            target1.setText("");
            target2.setText("");

        }
    }
}
