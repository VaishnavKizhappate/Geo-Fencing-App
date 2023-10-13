package com.example.geofencing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class profileactivity extends AppCompatActivity {

    TextView USERNAME,ADDRESS,EMAIL,PHONE;
    String username,address,email,phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profileactivity);

        USERNAME = findViewById(R.id.prousername);
        ADDRESS = findViewById(R.id.proaddress);
        EMAIL = findViewById(R.id.proemail);
        PHONE = findViewById(R.id.phone);

        HashMap<String,String>m=new SessionManager(this).getUserDetails();
        username =m.get("user_name");
        address =m.get("address");
        email =m.get("email");
        phone =m.get("phone");
        USERNAME.setText("Username : "+username);
        ADDRESS.setText("address :"+address);
        EMAIL.setText("email : "+email);
        PHONE.setText("phone : "+phone);
        Toast.makeText(getApplicationContext(),username,Toast.LENGTH_SHORT).show();

    }



}