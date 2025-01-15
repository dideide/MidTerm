package com.example.midterm.ActivityPages;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.carrentalapp.Model.Vehicle;
import com.example.midterm.R;

public class VehicleInfoActivity extends AppCompatActivity {

    //VEHICLE OBJECT
    private Vehicle vehicle;
    //VEHICLE TITLE
    private TextView vehicleTitle;
    //VEHICLE IMAGE OBJECT
    private ImageView vehicleImage;
    //VEHICLE PRICE
    private TextView vehiclePrice;

    //VEHICLE AVAILABILITY FIELD
    private ConstraintLayout available;
    private ConstraintLayout notAvailable;

    //GOING BACK BUTTON
    private Button back;
    private Button book;

    //VEHICLE INFO FIELD
    private TextView year, manufacturer, model, mileage, seats, type;

    //INSURANCE OPTION
    private RadioGroup insuranceOption;


    //INSURANCE DATABASE TABLE

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initComponents();



    }

    private void initComponents() {

        //INITIALIZING COMPONENTS
        vehicle = (Vehicle) getIntent().getSerializableExtra("VEHICLE");
        back = findViewById(R.id.back);
        vehicleTitle = findViewById(R.id.vehicleTitle);
        vehicleImage = findViewById(R.id.vehicleImage);

        available = findViewById(R.id.available);
        notAvailable = findViewById(R.id.notAvailable);

        //VEHICLE INFO FIELD
        year = findViewById(R.id.year);
        manufacturer = findViewById(R.id.manufacturer);
        model = findViewById(R.id.model);
        mileage = findViewById(R.id.mileage);
        seats = findViewById(R.id.seats);
        type = findViewById(R.id.type);

        //VEHICLE PRICE
        vehiclePrice = findViewById(R.id.vehiclePrice);
    }
}