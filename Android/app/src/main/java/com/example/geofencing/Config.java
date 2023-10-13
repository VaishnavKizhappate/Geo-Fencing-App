package com.example.geofencing;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;

public class Config {

    public static String baseURL = "http://192.168.1.3/ourgeo/";

    public static ProgressDialog mProgressDialog;


    public static void showSimpleProgressDialog(Context context) {
        try {
            if (mProgressDialog == null) {
                mProgressDialog = ProgressDialog.show(context, null, "Loading...");
                mProgressDialog.setCancelable(false);
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

    public static void removeSimpleProgressDialog() {
        try {
            if (mProgressDialog != null) {
                if (mProgressDialog.isShowing()) {
                    mProgressDialog.dismiss();
                    mProgressDialog = null;
                }
            }
        } catch (IllegalArgumentException ie) {
            Log.e("Log", "inside catch IllegalArgumentException");
            ie.printStackTrace();

        } catch (RuntimeException re) {
            Log.e("Log", "inside catch RuntimeException");
            re.printStackTrace();
        } catch (Exception e) {
            Log.e("Log", "Inside catch Exception");
            e.printStackTrace();
        }

    }
}
