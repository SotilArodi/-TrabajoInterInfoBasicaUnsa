package com.Rivas.chatbot;

import android.provider.ContactsContract;

public class Usuario {
    int Id;
    String CUI,Password;

    public Usuario() {
    }

    public Usuario(String CUI, String password) {
        this.CUI = CUI;
        Password = password;
    }
    public boolean isNull(){
        if (CUI.equals("") && Password.equals("")){
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "Id=" + Id +
                ", CUI='" + CUI + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getCUI() {
        return CUI;
    }

    public void setCUI(String CUI) {
        this.CUI = CUI;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
