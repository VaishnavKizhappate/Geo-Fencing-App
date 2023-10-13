package com.example.geofencing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
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

public class feedbackactivity extends AppCompatActivity {
    ImageView happy,bad;
String status,error,feedback,email;
String url = Config.baseURL +"feedback.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedbackactivity);
        happy=findViewById(R.id.happyface);
        bad=findViewById(R.id.sadface);
        HashMap<String,String>m=new SessionManager(this).getUserDetails();
        email=m.get("email");

        happy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                feedback="Happy";
                feedback();


            }
        });
        bad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                feedback="Bad";
                feedback();


            }
        });

    }
    private void feedback(){
        StringRequest request= new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonobject = new JSONObject(response);
                    status = jsonobject.getString("status");
                    error = jsonobject.getString("message");

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (status.equals("0")) {
                    Toast.makeText(feedbackactivity.this, error, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(feedbackactivity.this, "sending...", Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(feedbackactivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String>map=new HashMap<>();
                map.put("email",email);
                map.put("feedback",feedback);




                return map;
            }
        };
        RequestQueue requestqueue= Volley.newRequestQueue(this);
        requestqueue.add(request);



    }

}

