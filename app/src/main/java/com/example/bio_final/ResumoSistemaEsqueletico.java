package com.example.bio_final;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ResumoSistemaEsqueletico extends AppCompatActivity {

    WebView Web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_sistema_esqueletico);

        Web = (WebView)findViewById(R.id.webEsqueleto);
        WebSettings webSettings = Web.getSettings();
        webSettings.setJavaScriptEnabled(true);
        Web.setWebViewClient(new ResumoSistemaEsqueletico.Cal());
        Web.loadUrl("https://esqueletico-450a9.web.app");
    }

    private class Cal extends WebViewClient {
        @Override
        public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
            return false;
        }
    }
}
