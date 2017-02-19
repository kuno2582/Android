package com.example.kuno.webviewex;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

//기본적으로 권한부여가 필요 (manifests)
public class MainActivity extends AppCompatActivity {

    WebView wvWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wvWeb = (WebView) findViewById(R.id.wvWeb);

        wvWeb.loadUrl("http://kunoo.tistory.com");

        WebSettings webSettings = wvWeb.getSettings();
        webSettings.setJavaScriptEnabled(true);

    }
}
