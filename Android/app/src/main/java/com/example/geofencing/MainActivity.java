package com.example.geofencing;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.geofencing.password.MobileActivity;
import com.example.geofencing.services.LocationService;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText username,password;
    TextView createnewaccount,forgetpassword;
    Button submit;
    String url = Config.baseURL + "logintable.php";
    String status,error,id,uname,pword,address,landmark,city,email,phone,guardian,nationality,dob,gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        createnewaccount = findViewById(R.id.newaccount);
        forgetpassword = findViewById(R.id.forgetpassword);
        submit = findViewById(R.id.btnSubmit);

        createnewaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent register = new Intent(getApplicationContext(),regpage.class);
                startActivity(register);
            }
        });

        forgetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent forgetpassword = new Intent(getApplicationContext(), MobileActivity.class);
                startActivity(forgetpassword);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userReg();

            }
        });



    }



    private void userReg()
    {
        String user,pass;
        user=username.getText().toString();
        pass=password.getText().toString();



        if (TextUtils.isEmpty(user))
        {
            username.setError("please enter first name");
            username.requestFocus();
            return;
        }
        else if (TextUtils.isEmpty(pass))
        {
            password.setError("please enter password");
            password.requestFocus();
            return;
        }

        Config.showSimpleProgressDialog(this);

        StringRequest request= new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Config.removeSimpleProgressDialog();
                try {
                    JSONObject jsonobject = new JSONObject(response);
                    status = jsonobject.getString("status");
                    error = jsonobject.getString("message");
                    id=jsonobject.getString("id");
                    uname=jsonobject.getString("user_name");
                    pword=jsonobject.getString("password");
                    address=jsonobject.getString("address");
                    landmark=jsonobject.getString("landmark");
                    city=jsonobject.getString("city");
                    email=jsonobject.getString("email");
                    phone=jsonobject.getString("phone");
                    guardian=jsonobject.getString("guardian");
                    nationality=jsonobject.getString("nationality");
                    dob=jsonobject.getString("dob");
                    gender=jsonobject.getString("gender");

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if ("0".equals(status)) {
                    Toast.makeText(MainActivity.this, error, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, error, Toast.LENGTH_SHORT).show();
                    new SessionManager(getApplicationContext()).createLoginSession(id,uname,pword,address,landmark,city,email,phone,guardian,nationality,dob,gender);
                    Intent I=new Intent(MainActivity.this,homepage.class);
                    startActivity(I);
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Config.removeSimpleProgressDialog();
                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String>map=new HashMap<>();
                map.put("user_name",user);
                map.put("password",pass);

                return map;
            }
        };
        RequestQueue requestqueue= Volley.newRequestQueue(this);
        requestqueue.add(request);
    }

}