package com.Rivas.chatbot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {
    MediaPlayer next;
    private EditText cui,password;
    daoUsuario dao;
    //Expresiones Regulares para validar formularios
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[0-9])" +         //1 digito
                    "(?=.*[a-z])" +         //1 letra minúscula
                    "(?=.*[A-Z])" +         //1 letra mayúscula
                    "(?=.*[@#$%^&+=])" +    //1 caracter especial
                    "(?=\\S+$)" +           //No espacios
                    ".{6,}" +               //6 caracteres
                    "$");
    private static final Pattern CUI_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[0-9])" +
                    "(?=\\S+$)" +
                    ".{8,}" +
                    "$");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        next = MediaPlayer.create(this,R.raw.next);
        Button button = findViewById(R.id.button);
        button.setOnClickListener((View v) -> goToMainActivity());
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener((View v) -> goToNoStudentActivity());
        cui = findViewById(R.id.editTextTextPersonName);
        password = findViewById(R.id.editTextTextPassword);
        dao = new daoUsuario(this);
    }

    private void goToMainActivity(){
        String u = cui.getText().toString();
        String p = password.getText().toString();
        if (u.equals("") && p.equals("")){
            Toast.makeText(this, "ERROR: Campos Vacíos", Toast.LENGTH_LONG).show();
            cui.setError("Campo Vacío");
            password.setError("Campo Vacío");
        } else if (!CUI_PATTERN.matcher(u).matches()){
            Toast.makeText(this, "ERROR: CUI inválido", Toast.LENGTH_LONG).show();
            cui.setError("CUI inválido, ej: 20108456");
        } else if (!PASSWORD_PATTERN.matcher(p).matches()){
            Toast.makeText(this, "ERROR: Contraseña muy débil", Toast.LENGTH_LONG).show();
            password.setError("Minimo: 1 minúscula, 1 mayúscula, 1 símbolo, 1 dígito y 6 caracteres");
        }else if (dao.login(u,p) == 1){
            Usuario ux = dao.getUsuario(u,p);
            Intent i2 = new Intent(LoginActivity.this, Menu_Activity.class);
            cui.setError(null);
            password.setError(null);
            next.start();
            Toast.makeText(this, "Welcome", Toast.LENGTH_LONG).show();
            i2.putExtra("Id",ux.getId());
            startActivity(i2);
            finish();
        } else {
            Toast.makeText(this, "Usuario y/o Password incorrectos", Toast.LENGTH_LONG).show();
            cui.setError("No coincide con contraseña o no está registrado");
            password.setError("No coincide con e-mail o no está registrado");
        }
    }

    private void goToNoStudentActivity(){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}