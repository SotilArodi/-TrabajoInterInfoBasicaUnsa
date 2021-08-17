package com.Rivas.chatbot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu_Activity extends AppCompatActivity {
    MediaPlayer next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        next = MediaPlayer.create(this,R.raw.next);
        Button btnChatbot = findViewById(R.id.button6);
        Button btnPreguntas = findViewById(R.id.button12);
        btnPreguntas.setOnClickListener((View v) -> {
            Intent i2 = new Intent(this, Preguntas.class);
            next.start();
            startActivity(i2);
        });
        btnChatbot.setOnClickListener((View v) -> {
            Intent i = new Intent(this,chatbot_IBM_watsson.class);
            next.start();
            startActivity(i);
        });
    }
}