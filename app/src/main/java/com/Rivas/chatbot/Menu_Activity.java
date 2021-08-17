package com.Rivas.chatbot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu_Activity extends AppCompatActivity {
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
            Intent i = new Intent(this,chatbot_IBM_watsson.class);
            startActivity(i);
        });
    }
}