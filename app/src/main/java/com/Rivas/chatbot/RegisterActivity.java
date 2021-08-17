package com.Rivas.chatbot;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {
    MediaPlayer back;
    private EditText cui, password;
    daoUsuario dao;
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
        setContentView(R.layout.activity_no_student);
        back = MediaPlayer.create(this,R.raw.back);
        cui = findViewById(R.id.editTextTextEmailAddress);
        password = findViewById(R.id.editTextTextPassword2);
        dao = new daoUsuario(this);
        Button button3 = findViewById(R.id.button3);
        Button btnSignUp = findViewById(R.id.button5);
        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(v -> {
            Intent i2 = new Intent(this,UnsaOficialActivity.class);
            startActivity(i2);
        });
        button3.setOnClickListener((View v) -> goToLoginActivity());
        btnSignUp.setOnClickListener((View v) -> {
            Usuario u = new Usuario();
            u.setCUI(cui.getText().toString());
            u.setPassword(password.getText().toString());
            if (!u.isNull()){
                Toast.makeText(this, "ERROR: Campos vacíos", Toast.LENGTH_LONG).show();
                cui.setError("Campo Vacío");
                password.setError("Campo vacío");
            } else if (!CUI_PATTERN.matcher(u.getCUI()).matches()){
                Toast.makeText(this, "ERROR: CUI no válido", Toast.LENGTH_LONG).show();
                cui.setError("CUI inválido, ej: 20108542");
            } else if (!PASSWORD_PATTERN.matcher(u.getPassword()).matches()){
                Toast.makeText(this, "ERROR: Contraseña muy débil", Toast.LENGTH_LONG).show();
                password.setError("Minimo: 1 minúscula, 1 mayúscula, 1 símbolo, 1 dígito y 6 caracteres");
            }else if (dao.insertUsuario(u)){
                Intent i2 = new Intent(RegisterActivity.this, LoginActivity.class);
                cui.setError(null);
                password.setError(null);
                Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_LONG).show();
                back.start();
                startActivity(i2);
                finish();
            } else {
                Toast.makeText(this, "Usuario ya registrado", Toast.LENGTH_LONG).show();
                cui.setError("Usuario ya registrado");
                password.setError("Usuario ya registrado");
            }
        });
    }
    private void goToLoginActivity(){
        Intent intent = new Intent(this, LoginActivity.class);
        back.start();
        startActivity(intent);
    }
}