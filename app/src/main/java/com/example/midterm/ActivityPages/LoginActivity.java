package com.example.midterm.ActivityPages;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.midterm.Database.CustomerDao;
import com.example.midterm.Database.Project_Database;
import com.example.midterm.R;
import com.example.midterm.Session.Session;


public class LoginActivity extends AppCompatActivity {

    private TextView register;
    private TextView forgotPass;
    private Button login;

    private EditText email;
    private EditText password;

    private Project_Database db;

    private Button customer;
    private Button vehicleCategory;
    private Button vehicle;

    private Button populate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


    }

    //This will initialize all the clickable components in Login page
    private void initComponents(){

        //Register Button
        register = findViewById(R.id.register);

        //Login Button
        login = findViewById(R.id.login);

        //Forgot Password Button
        forgotPass = findViewById(R.id.forgot_password);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);


        db = Room.databaseBuilder(getApplicationContext(), Project_Database.class, "car_rental_db").allowMainThreadQueries().build();
    }



    //This will handle all the click events on the login page
    private void clickListenHandler(){

        //Register Listener
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomerDao customerDao = db.customerDao();
                for(com.example.carrentalapp.Model.Customer c: customerDao.getAll()){
                    Log.d("MainActivity", "CUSTOMER => " + c.toString());
                }
            }
        });
        //Login Listener
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomerDao customerDao = db.customerDao();
                com.example.carrentalapp.Model.Customer check = customerDao.findUser(email.getText().toString(),password.getText().toString());

                if(check != null){
                    Session.save(LoginActivity.this,"customerID",check.getCustomerID()+"");
                    Session.save(LoginActivity.this,"isLoggedIn","true");

                }else{
                    toast("Unsuccessful");
                }
            }

            private void toast(String txt){
                Toast toast = Toast.makeText(getApplicationContext(),txt,Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}
