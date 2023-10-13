package com.example.geofencing.map;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

public class AreaSession {

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;


    public AreaSession(Context context){
        this._context = context;
        pref = _context.getSharedPreferences("Area", 0);
        editor = pref.edit();
    }


    public void saveData(String myLatitude, String myLongitude, String pointLatitude,
                         String pointLongitude, String radius){
        editor.putString("myLatitude", myLatitude);
        editor.putString("myLongitude", myLongitude);
        editor.putString("pointLatitude", pointLatitude);
        editor.putString("pointLongitude", pointLongitude);
        editor.putString("radius", radius);
        editor.commit();
    }


    public HashMap<String, String> getData(){
        HashMap<String, String> user = new HashMap<>();
        user.put("myLatitude", pref.getString("myLatitude", null));
        user.put("myLongitude", pref.getString("myLongitude", null));
        user.put("pointLatitude", pref.getString("pointLatitude", null));
        user.put("pointLongitude", pref.getString("pointLongitude", null));
        user.put("radius", pref.getString("radius", null));
        return user;
    }

}
