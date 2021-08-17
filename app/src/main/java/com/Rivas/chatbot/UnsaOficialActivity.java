package com.Rivas.chatbot;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class UnsaOficialActivity extends AppCompatActivity {
    String url = "https://www.unsa.edu.pe/";
    WebView myWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unsa_oficial);
        myWebView = (WebView) findViewById(R.id.webview2);
        assert myWebView != null;

        WebSettings webSettings = myWebView.getSettings();
        webSettings.setSupportZoom(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccess(true);
        myWebView.getSettings().setAppCacheEnabled(true);
        myWebView.getSettings().setDatabaseEnabled(true);
        myWebView.getSettings().setDomStorageEnabled(true);

        if (Build.VERSION.SDK_INT >= 22){
            webSettings.setMixedContentMode(0);
            myWebView.setLayerType(View.LAYER_TYPE_HARDWARE,null);
        } else if (Build.VERSION.SDK_INT >= 19){
            myWebView.setLayerType(View.LAYER_TYPE_HARDWARE,null);
        } else {
            myWebView.setLayerType(View.LAYER_TYPE_SOFTWARE,null);
        }

        myWebView.setWebViewClient(new WebViewClient());
        myWebView.setWebChromeClient(new WebChromeClient());
        myWebView.setWebViewClient(new UnsaOficialActivity.MyWebViewClient());
        myWebView.setVerticalScrollBarEnabled(false);

        myWebView.loadUrl(url);
    }

    private class MyWebViewClient extends WebViewClient{
        @Override
        public void onPageStarted (WebView view, String url, Bitmap favicon){
            super.onPageStarted(view,url,favicon);
        }

        @Override
        public void onPageFinished (WebView view, String url){
            findViewById(R.id.webview2).setVisibility(View.VISIBLE);
        }
    }
}