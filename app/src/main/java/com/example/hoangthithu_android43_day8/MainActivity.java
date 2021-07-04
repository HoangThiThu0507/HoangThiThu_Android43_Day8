package com.example.hoangthithu_android43_day8;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.databinding.DataBindingUtil;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.hoangthithu_android43_day8.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //TextView tvChooseTags, tvChooseWeeks;
    //TextView tvTune;
    private String selectedItem = "";
    //TextView tvTime,tvDate;
    int cyear, cmonth, cday;
    int chour, cminute;
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        //tvChooseTags = findViewById(R.id.tvChooseTags);
       // tvChooseWeeks = findViewById(R.id.tvChooseWeeks);
        //tvTune = findViewById(R.id.tvTune);
        Spinner spin = (Spinner) findViewById(R.id.spinner);
       // tvTime = findViewById(R.id.tvTime);
       // tvDate = findViewById(R.id.tvDate);
        binding.tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                cyear= calendar.get(Calendar.YEAR);
                cmonth = calendar.get(Calendar.MONTH);
                cday= calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        binding.tvDate.setText( dayOfMonth+"/"+(month+1)+"/"+year);
                    }
                },cyear,cmonth,cday);
                datePickerDialog.show();
            }
        });
        binding.tvTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                chour = calendar.get(Calendar.HOUR_OF_DAY);
                cminute = calendar.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        binding.tvTime.setText(hourOfDay+" : "+minute);
                    }
                },chour,cminute,false);
                timePickerDialog.show();
            }
        });
        //  menu2 = findViewById(R.id.menu2);
        List<String> arr = new ArrayList<String>();
        arr.add("Work");
        arr.add("Friend");
        arr.add("Family");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arr);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spin.setAdapter(dataAdapter);

        binding.tvChooseTags.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] strings = {"Family", "Game", "Android", "VTC", "Friend"};
                boolean[] booleans = {false, false, false, false, false};
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Choose tags")
                        .setMultiChoiceItems(strings, booleans, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                if (isChecked)
                                    booleans[which] = true;
                                else
                                    booleans[which] = false;

                            }
                        })
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                for (int i = 0; i < booleans.length; i++) {
                                    if (booleans[i] == true) {
                                        selectedItem += strings[i] + ", ";

                                    }
                                }
                                binding.tvChooseTags.setText(selectedItem);
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .create();
                alertDialog.show();
            }
        });
        binding.tvChooseWeeks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] strings = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", " Saturday", "Sunday"};
                boolean[] booleans = {false, false, false, false, false, false, false};
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Choose weeks")
                        .setMultiChoiceItems(strings, booleans, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                // selectedItem = strings[which];
                                //choose.add(selectedItem);
                                if (isChecked)
                                    booleans[which] = true;
                                else
                                    booleans[which] = false;

                            }
                        })
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                for (int i = 0; i < booleans.length; i++) {
                                    if (booleans[i] == true) {
                                        selectedItem += strings[i] + ", ";

                                    }
                                }
                                binding.tvChooseWeeks.setText(selectedItem);
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .create();
                alertDialog.show();
            }
        });
        binding.tvTune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvTuneClicked();

            }
        });
    }
    private void tvTuneClicked()  {

        PopupMenu popup = new PopupMenu(this, this.binding.tvTune);
        popup.inflate(R.menu.menu);

        Menu menu = popup.getMenu();

        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                //return menuItemClicked(item);
                switch (item.getItemId()) {
                    case R.id.menu1:
                        break;
                    case R.id.menu2:
                        String[] strings = {"Nexus Tune", "Winphone tune", "Peep tune", "Nokia tune", "Etc"};
                        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this)
                                .setSingleChoiceItems(strings, 0, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Toast.makeText(getBaseContext(), strings[which], Toast.LENGTH_LONG).show();
                                    }
                                })
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                })
                                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                })
                                .create();
                        alertDialog.show();
                        break;

                }
                return true;
            }
        });
        popup.show();
    }
    private boolean menuItemClicked(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu1:
                break;
            case R.id.menu2:
                String[] strings = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", " Saturday", "Sunday"};
                boolean[] booleans = {false, false, false, false, false, false, false};
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Choose weeks")
                        .setMultiChoiceItems(strings, booleans, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                // selectedItem = strings[which];
                                //choose.add(selectedItem);
                                if (isChecked)
                                    booleans[which] = true;
                                else
                                    booleans[which] = false;

                            }
                        })
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                for (int i = 0; i < booleans.length; i++) {
                                    if (booleans[i] == true) {
                                        selectedItem += strings[i] + ", ";

                                    }
                                }
                                binding.tvChooseWeeks.setText(selectedItem);
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .create();
                alertDialog.show();
        }
        return true;
    }


}