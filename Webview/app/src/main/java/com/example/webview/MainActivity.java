package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.security.keystore.StrongBoxUnavailableException;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;



public class MainActivity extends AppCompatActivity {
Button btn;
EditText edsearch;
WebView webview;
String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button) findViewById(R.id.search);
        edsearch=(EditText) findViewById(R.id.url);
        webview=(WebView) findViewById(R.id.web);
        webview.setWebViewClient(new MyBrowser());
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                url=edsearch.getText().toString();
                webview.getSettings().setLoadsImagesAutomatically(true);
                webview.getSettings().setJavaScriptEnabled(true);
                webview.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_INSET);
                webview.loadUrl(url);
            }
        });

    }
    private class MyBrowser extends WebViewClient{

        /*@Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;


        }*/

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            final Uri uri=request.getUrl();
            return handleUri(uri);

        }
        private boolean handleUri (Uri uri){
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    webview.loadUrl(String.valueOf(uri));
                }
            });
         return true;

        }
    }

}