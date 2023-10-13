package com.example.geofencing.password;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.goodiebag.pinview.Pinview;

import com.example.geofencing.R;

public class OTPActivity extends AppCompatActivity {

    TextView tv;
    Button btnVerify;
    Pinview pin;
    String otp1, otp2, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        tv = findViewById(R.id.t1);
        pin = findViewById(R.id.pin);
        btnVerify = findViewById(R.id.btnVerify);

        Intent i = getIntent();
        otp1 = i.getStringExtra("otp");
        phone = i.getStringExtra("phone");

        tv.setText("We have sent an OTP to " + phone + ". Please enter it to verify your number");

        btnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                otp2 = pin.getValue();

                if (otp1.equals(otp2)) {
                    Intent i = new Intent(getApplicationContext(), ResetActivity.class);
                    i.putExtra("phone", phone);
                    startActivity(i);
                    finish();
                } else {
                    Toast.makeText(OTPActivity.this, "Incorrect OTP", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}