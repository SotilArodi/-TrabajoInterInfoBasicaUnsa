package com.Rivas.chatbot;

import android.app.Application;
import com.androidnetworking.AndroidNetworking;

public class chatbotapp extends Application {

    @Override
    public void onCreate() {//Sobreescribimos el metodo
        super.onCreate();
        AndroidNetworking.initialize(getApplicationContext());
    }
}
