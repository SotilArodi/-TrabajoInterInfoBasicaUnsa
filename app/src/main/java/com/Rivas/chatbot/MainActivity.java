package com.Rivas.chatbot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView messagesTextView;
    EditText inputEditText;
    Button sendButton;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        messagesTextView = findViewById(R.id.messagesTextView);
        inputEditText = findViewById(R.id.inputEditText);
        sendButton = findViewById(R.id.sendButton);
        sendButton.setOnClickListener(new View.OnClickListener() {//Una accion cuando se le haga click al boton
            @Override
            public void onClick(View view) {
                String input = inputEditText.getText().toString();//Almacenamos la cadena de entrada
                messagesTextView.append(Html.fromHtml("<p><b>Tu:</b>"+ input  + "</p>"));
                inputEditText.setText("");//Limpiamos el edittext
                
            }

        });
    }
}