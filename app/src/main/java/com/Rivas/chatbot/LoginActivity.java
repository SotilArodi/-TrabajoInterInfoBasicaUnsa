package com.Rivas.chatbot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button button = findViewById(R.id.button);
        button.setOnClickListener((View v) -> goToMainActivity());
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener((View v) -> goToNoStudentActivity());
    }

    private void goToMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void goToNoStudentActivity(){
        Intent intent = new Intent(this,NoStudentActivity.class);
        startActivity(intent);
    }
}