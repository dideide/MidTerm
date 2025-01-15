package com.example.midterm.ActivityPages;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.midterm.Database.CustomerDao;
import com.example.midterm.Database.Project_Database;
import com.example.midterm.R;


public class RegistrationActivity extends AppCompatActivity {

    private Button register;
    private TextView login;

    private TextView expiryDate;
    private TextView dob;
    private CustomerDao customerDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        initComponents();

        clickListenHandler();

    }

    //Initialize all the components in Register Page
    private void initComponents() {

        //Register Button
        register = findViewById(R.id.register);
        //Login Button
        login = findViewById(R.id.login);
        //Expiry Button
        expiryDate = findViewById(R.id.expiryDate);
        //Date of Birth Button
        dob = findViewById(R.id.dob);

        //Get the Customer Room (table)
        customerDao = Room.databaseBuilder(getApplicationContext(), Project_Database.class, "car_rental_db").allowMainThreadQueries()
                .build()
                .customerDao();

    }

    //This method handles all the click events
    private void clickListenHandler() {

        //Expiry Date Listener
        expiryDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCalendar(expiryDate);
            }
        });

        //Date of Birth Listener
        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCalendar(dob);
            }
        });

        //Login Listener
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerPage = new Intent(RegistrationActivity.this, LoginActivity.class);
                startActivity(registerPage);
            }
        });

        //Register Listener
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (customerDao != null) {
                    //If customer object is null -> Incomplete form
                    //If customer object not null -> Complete form

                }
            }
        });
    }

    //Opening a Calendar Dialog
    private void openCalendar(final TextView dateFieldButton) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this);

        datePickerDialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String date = year + "-" + month + "-" + dayOfMonth;
                dateFieldButton.setText(date);
            }
        });

        datePickerDialog.show();
    }
}
