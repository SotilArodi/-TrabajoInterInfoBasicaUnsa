package com.Rivas.chatbot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu_Activity extends AppCompatActivity {
    private String url = "https://web-chat.global.assistant.watson.cloud.ibm.com/preview.html?region=us-east&integrationID=13367b61-53cd-43c7-9ac5-7a4488e48aab&serviceInstanceID=dba61788-800e-4311-8755-6fd8a1d2d1a8";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Button btnChatbot = findViewById(R.id.button6);
        Button btnPreguntas = findViewById(R.id.button12);
        btnPreguntas.setOnClickListener((View v) -> {
            Intent i2 = new Intent(this, Preguntas.class);
            startActivity(i2);
        });
        btnChatbot.setOnClickListener((View v) -> {
            Uri link = Uri.parse(url);
            Intent i = new Intent(Intent.ACTION_VIEW,link);
            startActivity(i);
        });
    }
}