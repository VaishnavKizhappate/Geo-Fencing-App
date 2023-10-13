package com.example.geofencing.map;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.example.geofencing.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.HashMap;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    String myLatitude, myLongitude, pointLatitude, pointLongitude, radius;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        HashMap<String, String> data = new AreaSession(this).getData();
        myLatitude = data.get("myLatitude");
        myLongitude = data.get("myLongitude");
        pointLatitude = data.get("pointLatitude");
        pointLongitude = data.get("pointLongitude");
        radius = data.get("radius");

        LatLng point = new LatLng(Double.parseDouble(pointLatitude), Double.parseDouble(pointLongitude));

        CircleOptions circleOptions = new CircleOptions();
        circleOptions.center(point);
        circleOptions.radius(Double.parseDouble(radius) * 1000);
        circleOptions.fillColor(0x30ff0000);
        circleOptions.strokeColor(Color.RED);
        circleOptions.strokeWidth(5);

        mMap.addCircle(circleOptions);

        //seattle coordinates
        LatLng myLocation = new LatLng(Double.parseDouble(myLatitude), Double.parseDouble(myLongitude));
        mMap.addMarker(new MarkerOptions().position(myLocation).title("My Location"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(myLocation, 12));


    }
}