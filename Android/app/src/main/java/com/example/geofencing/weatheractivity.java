package com.example.geofencing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class weatheractivity extends AppCompatActivity {
    WebView w;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weatheractivity);
        w = findViewById(R.id.webView);
        WebSettings webSettings = w.getSettings();
        webSettings.setJavaScriptEnabled(true);
        w.loadUrl("https://www.windy.com/-Rain-thunder-rain?rain,10.516,76.216,5");
        w.setWebViewClient(new WebViewClient());
    }

    @Override
    public void onBackPressed() {
        if (w.canGoBack()){
            w.goBack();
        } else {
            super.onBackPressed();
        }
    }
}