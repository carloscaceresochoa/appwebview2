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
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private WebView webView;
    private EditText urltext;
    private static final String CHANNEL_ID = "notificacion10";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView=findViewById(R.id.webview);
        urltext=findViewById(R.id.urltext);
    }



    public void navegar(View view){
     try {
         webView.getSettings().setDomStorageEnabled(true);
         webView.getSettings().setJavaScriptEnabled(true);
         webView.clearFormData();
         webView.clearHistory();
         webView.clearCache(true);
         webView.setWebViewClient(new WebViewClient());
         webView.loadUrl("http://" + urltext.getText().toString());
     }
     catch(Exception e){
         Toast.makeText(this,"Pagina no Encontrada",
                 Toast.LENGTH_LONG).show();
     }

    }

    public void notificacion(View view){

        Intent intent = new Intent();

        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);


        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_baseline_notifications_active_24)
                .setContentTitle("Notificación Cumpleaños")
                .setContentText("Feliz Cumpleaños Carlos")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)

                .setAutoCancel(true);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);


        int notificationId = 100;
        notificationManager.notify(notificationId, builder.build());

    }
}