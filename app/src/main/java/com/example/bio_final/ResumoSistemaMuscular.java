package com.example.bio_final;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ResumoSistemaMuscular extends AppCompatActivity {

    WebView Mweb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_sistema_muscular);

        Mweb = (WebView)findViewById(R.id.musculoweb);

        WebSettings webSettings = Mweb.getSettings();
        webSettings.setJavaScriptEnabled(true);
        Mweb.setWebViewClient(new ResumoSistemaMuscular.Cal());
        Mweb.loadUrl("https://muscular-28100.web.app");
    }

    private class Cal extends WebViewClient {
        @Override
        public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
            return false;
        }
    }
}
