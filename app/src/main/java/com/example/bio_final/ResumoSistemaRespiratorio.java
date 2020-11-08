package com.example.bio_final;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ResumoSistemaRespiratorio extends AppCompatActivity {

    WebView weby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_sistema_respiratorio);

        weby = (WebView)findViewById(R.id.web);
        WebSettings webSettings = weby.getSettings();
        webSettings.setJavaScriptEnabled(true);
        weby.setWebViewClient(new Call());
        weby.loadUrl("https://respiratorio-11ee1.web.app");
    }

    private class Call extends WebViewClient {
        @Override
        public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
            return false;
        }
    }
}
