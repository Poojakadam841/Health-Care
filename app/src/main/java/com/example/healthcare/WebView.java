package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;

public class WebView extends AppCompatActivity {
    android.webkit.WebView webView;
    VideoWebView videoWebView = new VideoWebView();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        webView = findViewById(R.id.web_view_web_view);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.loadUrl("https://docvita.com/mumbai/therapists?gclid=CjwKCAiA1JGRBhBSEiwAxXblwcIrxO60HhpHrml1U_2iV1gaqKOeGJbQEqQuyY28jvvE304gwslkYxoCGKEQAvD_BwE");

    }
}


class VideoWebView extends WebViewClient {

    @Override
    public boolean shouldOverrideUrlLoading(android.webkit.WebView view, String url) {
        view.loadUrl(url);
        return super.shouldOverrideUrlLoading(view, url);
    }
}