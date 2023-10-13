package com.example.geofencing.password;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import com.example.geofencing.Config;
import com.example.geofencing.R;

public class ResetActivity extends AppCompatActivity {

    EditText etPassword, etConfirmPassword;
    Button btnReset;
    ProgressBar p;

    String pass, cPass, phone;
    String status = "", url = Config.baseURL + "reset_password.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);

        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        btnReset = findViewById(R.id.btnReset);
        p = findViewById(R.id.progress);

        Intent i = getIntent();
        phone = i.getStringExtra("phone");


        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetPassword();
            }
        });
    }


    private void resetPassword() {
        pass = etPassword.getText().toString();
        cPass = etConfirmPassword.getText().toString();

        if (!pass.equals(cPass)) {
            Toast.makeText(this, "Password mismatch", Toast.LENGTH_SHORT).show();
            return;
        }

        p.setVisibility(View.VISIBLE);
        StringRequest s = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        p.setVisibility(View.INVISIBLE);
                        try {
                            JSONObject c = new JSONObject(response);
                            status = c.getString("StatusID");

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (status.equals("1")) {
                            Toast.makeText(ResetActivity.this, "Password changed successfully", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(ResetActivity.this, "Password cannot changed now. Try again later",
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        p.setVisibility(View.INVISIBLE);
                        Toast.makeText(ResetActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> map = new HashMap<>();
                map.put("phone", phone);
                map.put("password", pass);
                return map;
            }
        };
        RequestQueue q = Volley.newRequestQueue(this);
        q.add(s);
    }
}