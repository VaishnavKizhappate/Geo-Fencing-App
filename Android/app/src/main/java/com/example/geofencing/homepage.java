package com.example.geofencing;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.geofencing.services.LocationService;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import mumayank.com.airlocationlibrary.AirLocation;

public class homepage extends AppCompatActivity {

    Button start_locating, stop_locating, logout, navigate;
    long time = 500;
    String latitude, longitude, id;
    private AirLocation airLocation;
    private static ProgressDialog mProgressDialog;
    String num = "6235470494", status, message, url = Config.baseURL +"loc.php";
    ImageView compass, weather, bell, shield;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        checkPermissionLocation();

        start_locating = findViewById(R.id.start);
        stop_locating = findViewById(R.id.stop);
        logout = findViewById(R.id.logout);
        compass = findViewById(R.id.compass_image);
        navigate = findViewById(R.id.navigate);
        weather = findViewById(R.id.weather);
        bell = findViewById(R.id.bell);
        shield = findViewById(R.id.shield);

        id = new SessionManager(this).getUserDetails().get("id");

        compass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent compass = new Intent(getApplicationContext(),compassactivity.class);
                startActivity(compass);
            }
        });

        weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent weather = new Intent(getApplicationContext(),weatheractivity.class);
                startActivity(weather);
            }
        });

        bell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bell = new Intent(getApplicationContext(), NotificationsActivity.class);
                startActivity(bell);
            }
        });

        shield.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shield = new Intent(getApplicationContext(), RescueActivity.class);
                startActivity(shield);
            }
        });

        navigate.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            new Handler().postDelayed(new Runnable() {
                                                @Override
                                                public void run() {
                                                    Uri intentUri = Uri.parse("geo:0,0?q=");
                                                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, intentUri);
                                                    mapIntent.setPackage("com.google.android.apps.maps");
                                                    startActivity(mapIntent);
                                                }

                                            }, 1000);
                                        }
                                    });



        start_locating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i <= 10; i++) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            fetchlocation();
                        }
                    }, time);
                    time = time + 30000;
                }
            }
        });
    }


    private void fetchlocation() {

        airLocation = new AirLocation(homepage.this, true, true, new AirLocation.Callbacks() {
            @Override
            public void onSuccess(Location location) {
                Toast.makeText(homepage.this, "location fetched successfully", Toast.LENGTH_SHORT).show();
                double lat, lng;
                lat = location.getLatitude();
                lng = location.getLongitude();
                latitude = Double.toString(lat);
                longitude = Double.toString(lng);

                checkPermission();
            }

            @Override
            public void onFailed(AirLocation.LocationFailedEnum locationFailedEnum) {
                Toast.makeText(homepage.this, "location fetching failed.please check your internet connection", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        airLocation.onActivityResult(requestCode, resultCode, data);
    }


    public static void showSimpleProgressDialog(Context context, String title,
                                                String msg, boolean isCancelable) {
        try {
            if (mProgressDialog == null) {
                mProgressDialog = ProgressDialog.show(context, title, msg);
                mProgressDialog.setCancelable(isCancelable);
            }
            if (!mProgressDialog.isShowing()) {
                mProgressDialog.show();
            }
        } catch (IllegalArgumentException ie) {
            ie.printStackTrace();
        } catch (RuntimeException re) {
            re.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void sendloc() {
        String username = new SessionManager(this).getUserDetails().get("user_name");
        String msg = "Location of "+ username +": lat="+ latitude +", lng="+ longitude;
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(num, null, msg, null, null);

        uploadLocation();
    }


    public void checkPermission()
    {
        if (ContextCompat.checkSelfPermission(homepage.this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_DENIED) {

            // Requesting the permission
            ActivityCompat.requestPermissions(homepage.this, new String[] { Manifest.permission.SEND_SMS }, 2);
        }
        else {
            sendloc();
        }
    }


    private void uploadLocation()
    {
        StringRequest request= new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
//                Toast.makeText(homepage.this, response, Toast.LENGTH_SHORT).show();
                try {
                    JSONObject jsonobject = new JSONObject(response);
                    status = jsonobject.getString("status");
                    message = jsonobject.getString("message");

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                /*if (status.equals("0")) {
                    Toast.makeText(homepage.this, message, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(homepage.this, message, Toast.LENGTH_SHORT).show();
                }*/

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(homepage.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String>map=new HashMap<>();
                map.put("id", id);
                map.put("latitude", latitude);
                map.put("longitude", longitude);

                return map;
            }
        };
        RequestQueue requestqueue= Volley.newRequestQueue(this);
        requestqueue.add(request);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.item1:
                Intent intent = new Intent(getApplicationContext(),profileactivity.class);
                startActivity(intent);
                return true;
            case R.id.item2:
                 intent = new Intent(getApplicationContext(),feedbackactivity.class);
                startActivity(intent);
                return true;
            case R.id.item3:
                intent = new Intent(getApplicationContext(),complaintactivity.class);
                startActivity(intent);

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    // Function to check and request permission.
    public void checkPermissionLocation()
    {
        if (ContextCompat.checkSelfPermission(homepage.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_DENIED) {

            // Requesting the permission
            ActivityCompat.requestPermissions(homepage.this, new String[] { Manifest.permission.ACCESS_FINE_LOCATION }, 1);
        }
        else {
            startService(new Intent(getApplicationContext(), LocationService.class));
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startService(new Intent(getApplicationContext(), LocationService.class));
            }
            else {
                Toast.makeText(homepage.this, "Location Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }

        if (requestCode == 2) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                sendloc();
            }
            else {
                Toast.makeText(homepage.this, "SMS Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}

