package com.example.geofencing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
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

public class regpage extends AppCompatActivity {

    EditText user_name,enter_password,confirm_password,address,landmark,city,guardian_relation,nationality,dob,email_id,phone_number;
    RadioGroup gender;
    Button submit;

    String url = Config.baseURL + "reg.php";
    String status,error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regpage);

        user_name = findViewById(R.id.username);
        enter_password = findViewById(R.id.password);
        confirm_password = findViewById(R.id.confirmpassword);
        address = findViewById(R.id.add);
        landmark = findViewById(R.id.lmark);
        city = findViewById(R.id.city);
       guardian_relation = findViewById(R.id.guardian);
       nationality= findViewById(R.id.nation);
        dob = findViewById(R.id.dob);
        email_id = findViewById(R.id.email);
       phone_number = findViewById(R.id.num);
       gender = findViewById(R.id.gender);
       submit = findViewById(R.id.submit);

       submit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
              userReg();
           }
       });






    }
    private void userReg()
    {
        String username,password,Address,Landmark,City,guardianAndRelation,Nationality,Dob,emailId,PhoneNumber,Gender,submit;
        username=user_name.getText().toString();
        password=enter_password.getText().toString();
        Address=address.getText().toString();
        Landmark=landmark.getText().toString();
        City=city.getText().toString();
        emailId=email_id.getText().toString();
        PhoneNumber=phone_number.getText().toString();
        guardianAndRelation=guardian_relation.getText().toString();
        Nationality=nationality.getText().toString();
        Dob=dob.getText().toString();

        int selectId =gender.getCheckedRadioButtonId();
        RadioButton rb=gender.findViewById(selectId);
        Gender=rb.getText().toString();

        if (TextUtils.isEmpty(username))
        {
            user_name.setError("please enter first name");
            user_name.requestFocus();
            return;
        }
        else if (TextUtils.isEmpty(password))
        {
            enter_password.setError("please enter password");
            enter_password.requestFocus();
            return;
        }
        else if (TextUtils.isEmpty(Address))
        {
            address.setError("please enter address");
            address.requestFocus();
            return;
        }

        else if (TextUtils.isEmpty(Landmark))
        {
           landmark.setError("please enter landmark");
            landmark.requestFocus();
            return;
        }
        else if (TextUtils.isEmpty(City))
        {
            city.setError("please enter city");
            city.requestFocus();
            return;
        }
        else if (TextUtils.isEmpty(emailId))
        {
            email_id.setError("please enter emailId");
            email_id.requestFocus();
            return;
        }
        else if (TextUtils.isEmpty(PhoneNumber))
        {
            phone_number.setError("please enter phone number");
           phone_number.requestFocus();
            return;
        }
        else if (TextUtils.isEmpty(guardianAndRelation))
        {
            guardian_relation.setError("please enter guardian and relation");
            guardian_relation.requestFocus();
            return;
        }

        else if (TextUtils.isEmpty(Nationality))
        {
           nationality.setError("please enter nationality");
           nationality.requestFocus();
            return;
        }
        else if (TextUtils.isEmpty(Dob))
        {
            dob.setError("please enter dob");
            dob.requestFocus();
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

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (status.equals("0")) {
                    Toast.makeText(regpage.this, error, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(regpage.this, error, Toast.LENGTH_SHORT).show();
                    finish();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Config.removeSimpleProgressDialog();
                Toast.makeText(regpage.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String>map=new HashMap<>();
                map.put("user_name",username);
                map.put("password",password);
                map.put("address",Address);
                map.put("landmark",Landmark);
                map.put("city",City);
                map.put("guardian",guardianAndRelation);
                map.put("nationality",Nationality);
                map.put("dob",Dob);
                map.put("gender",Gender);
                map.put("email",emailId);
                map.put("phone",PhoneNumber);
                return map;
            }
        };

        RequestQueue requestqueue= Volley.newRequestQueue(this);
        requestqueue.add(request);
    }

}