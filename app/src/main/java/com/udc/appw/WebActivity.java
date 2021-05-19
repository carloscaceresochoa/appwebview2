package com.udc.appw;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebActivity extends AppCompatActivity {
   private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        webView=findViewById(R.id.webapp);
        navegar();
    }

    public void navegar(){
        try {
            webView.getSettings().setDomStorageEnabled(true);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.clearFormData();
            webView.clearHistory();
            webView.clearCache(true);
            webView.setWebViewClient(new WebViewClient());
            //webView.loadUrl("http://appinv.usbcartagena.edu.co:8181/evalsemilleros/");
            webView.loadUrl("file:///android_asset/index.html");

        }
        catch(Exception e){
            Toast.makeText(this,"Pagina no Encontrada",
                    Toast.LENGTH_LONG).show();
        }

    }


}