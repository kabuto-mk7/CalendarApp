package com.example.calendarapptimeleft;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.Toast;
import java.util.ArrayList;


public class DayView extends AppCompatActivity {

    DatabaseHelper myDB;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dayview_page);

      ListView listView = (ListView) findViewById(R.id.listView);
      myDB = new DatabaseHelper(this);

      ArrayList<String> theList = new ArrayList<>();
      Cursor data = myDB.getListContents();

      if(data.getCount() == 0){
            Toast.makeText(DayView.this,"Your task list is empty...",Toast.LENGTH_LONG).show();
        }else{
            theList.add(data.getString(1));
            ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,theList);
            listView.setAdapter(listAdapter);
        }
    }
}