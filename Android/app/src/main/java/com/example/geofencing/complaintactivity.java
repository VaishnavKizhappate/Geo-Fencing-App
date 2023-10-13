package com.example.geofencing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class complaintactivity extends AppCompatActivity {

    EditText complaint;
    Button btn;
    String status,error,email,com;
    String url= Config.baseURL +"complaint.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaintactivity);
        complaint=findViewById(R.id.complaint);
        btn=findViewById(R.id.btncomplaint);
        HashMap<String,String>m=new SessionManager(complaintactivity.this).getUserDetails();
        email=m.get("email");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                complaintSend();
            }
        });

    }
    private void complaintSend(){
        com=complaint.getText().toString();
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
                if ("0".equals(status)) {
                    Toast.makeText(complaintactivity.this, error, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(complaintactivity.this, "sending...", Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(complaintactivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String>map=new HashMap<>();
                map.put("email",email);
                map.put("complaint",com);




                return map;
            }
        };
        RequestQueue requestqueue= Volley.newRequestQueue(this);
        requestqueue.add(request);

    }
}