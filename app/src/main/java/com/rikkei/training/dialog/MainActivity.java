package com.rikkei.training.dialog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button butDate, butClock, butPickTopping, butBrightness, butUSBStore, butTextMessagerLimit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        butClock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayClock();
            }
        });
        butDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayDate();
            }
        });
        butPickTopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayPickTopping();
            }
        });
        butBrightness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayBrightness();
            }
        });

    }

    private void displayBrightness() {
        Dialog dialog=new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialogbrightness);
        dialog.setCancelable(true);
        AppCompatButton butOK=dialog.findViewById(R.id.butOK);
        AppCompatButton butCancel=dialog.findViewById(R.id.butCancel);
        butCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        butOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void displayPickTopping() {
        String[] strings = {"Onion", "Lettuce", "Tomato"};
        boolean[] booleans = {false, true, true};
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Pick Your Topping")
                .setMultiChoiceItems(strings, booleans, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        Toast.makeText(getApplicationContext(), strings[which], Toast.LENGTH_LONG).show();
                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "OK", Toast.LENGTH_LONG).show();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Cancel", Toast.LENGTH_LONG).show();
                    }
                });
        alertDialog.show();
    }

    private void displayDate() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog date = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                calendar.set(year, month, dayOfMonth);
                Toast.makeText(getApplicationContext(), simpleDateFormat.format(calendar.getTime()), Toast.LENGTH_LONG).show();
            }
        }, year, month, day);
        date.show();
    }

    private void displayClock() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        TimePickerDialog clock = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
                calendar.set(0, 0, 0, hourOfDay, minute);
                Toast.makeText(getApplicationContext(), simpleDateFormat.format(calendar.getTime()), Toast.LENGTH_LONG).show();
            }
        }, hour, minute, true);
        clock.show();
    }

    private void init() {
        butBrightness = findViewById(R.id.butBrightness);
        butClock = findViewById(R.id.butClock);
        butDate = findViewById(R.id.butDate);
        butPickTopping = findViewById(R.id.butPickTopping);
        butUSBStore = findViewById(R.id.butUSBStore);
        butTextMessagerLimit = findViewById(R.id.butTextMessagerLimit);
    }
}