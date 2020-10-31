package com.example.calendarapptimeleft;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    CalendarView calendar;
    TextView textview;
    Button buttonAddEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendar = (CalendarView)findViewById(R.id.calendarView);
        textview = (TextView)findViewById(R.id.textView);
        buttonAddEvent = (Button)findViewById(R.id.buttonAddEvent);

        buttonAddEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opennewactivity();
            }
        });

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                textview.setText("Date is : " + dayOfMonth + " / " + (month+1) + " / " + year);
            }
        });
    }

    public void opennewactivity(){
        Intent intent = new Intent(this, AddEventPage.class);
        startActivity(intent);
    }

}
