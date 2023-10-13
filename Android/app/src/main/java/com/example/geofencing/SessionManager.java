package com.example.geofencing;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

public class SessionManager {
    // Shared Preferences
    SharedPreferences pref;

    // Editor for Shared preferences
    SharedPreferences.Editor editor;

    // Context
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Sharedpref file name
    private static final String PREF_NAME = "Login";

    // All Shared Preferences Keys
    private static final String IS_LOGIN = "IsLoggedIn";



    // Constructor
    public SessionManager(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    /**
     * Create login session
     * */
    public void createLoginSession(String id,String user_name,String password,String address,String landmark,String city,String email,String phone,String guardian,String nationality,String dob,String gender){
        // Storing login value as TRUE
        editor.putBoolean(IS_LOGIN, true);


        editor.putString("id",id);
        editor.putString("user_name",user_name);
        editor.putString("password",password);
        editor.putString("address",address);
        editor.putString("landmark",landmark);
        editor.putString("city",city);
        editor.putString("email",email);
        editor.putString("phone",phone);
        editor.putString("guardian",guardian);
        editor.putString("nationality",nationality);
        editor.putString("dob",dob);
        editor.putString("gender",gender);



        // commit changes
        editor.commit();
    }

    /**
     * Check login method wil check user login status
     * If false it will redirect user to login page
     * Else won't do anything
     * */
    public boolean checkLogin(){
        // Check login status
        if(this.isLoggedIn()) {
            return true;
        } else {
            return false;
            // user is not logged in redirect him to Login Activity
//            Intent i = new Intent(_context, LoginActivity.class);
            // Closing all the Activities
//            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            // Add new Flag to start new Activity
//            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            // Staring Login Activity
//            _context.startActivity(i);
        }

    }



    /**
     * Get stored session data
     * */
    public HashMap<String, String> getUserDetails(){
        HashMap<String, String> user = new HashMap<String, String>();

        user.put("id", pref.getString("id", null));
        user.put("user_name", pref.getString("user_name", null));
        user.put("password", pref.getString("password", null));
        user.put("address", pref.getString("address", null));
        user.put("landmark", pref.getString("landmark", null));
        user.put("city", pref.getString("city", null));
        user.put("email", pref.getString("email", null));
        user.put("phone", pref.getString("phone", null));
        user.put("guardian", pref.getString("guardian", null));
        user.put("nationality", pref.getString("nationality", null));
        user.put("dob", pref.getString("dob", null));
        user.put("gender", pref.getString("gender", null));

        // return user
        return user;
    }

    /**
     * Clear session details
     * */
    public void logoutUser(){
        // Clearing all data from Shared Preferences
        editor.clear();
        editor.commit();

        // After logout redirect user to Loing Activity
//        Intent i = new Intent(_context, LoginActivity.class);
        // Closing all the Activities
//        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        // Add new Flag to start new Activity
//        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Staring Login Activity
//        _context.startActivity(i);
    }

    /**
     * Quick check for login
     * **/
    // Get Login State
    public boolean isLoggedIn(){
        return pref.getBoolean(IS_LOGIN, false);
    }
}
