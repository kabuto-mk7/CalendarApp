package com.example.calendarapptimeleft;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddEventPage extends AppCompatActivity {

    DatabaseHelper myDB;
    Button buttonAddEvent;
    Button buttonViewEvent;
    EditText editText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addevent_page);

        editText = (EditText) findViewById(R.id.editText);
        buttonAddEvent = (Button) findViewById(R.id.buttonAddEvent);
        buttonViewEvent = (Button) findViewById(R.id.buttonViewEvents);
        myDB = new DatabaseHelper(this);

        buttonViewEvent.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V){
                openViewActivity();
            }
        });

        buttonAddEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = editText.getText().toString();
                if(editText.length() != 0){
                    AddData(newEntry);
                    editText.setText("");
                }else{
                    Toast.makeText(MainActivity.this,"Entry must not be empty!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void AddData(String newEntry){
        boolean insertData = myDB.addData(newEntry);
        if(insertData==true){
            Toast.makeText(MainActivity.this,"Task added!",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(MainActivity.this, "Something went wrong... try again",Toast.LENGTH_LONG).show();
        }
    }

    public void openViewActivity(){
        Intent intent = new Intent(this, DayView.class);
        startActivity(intent);
    }

}
