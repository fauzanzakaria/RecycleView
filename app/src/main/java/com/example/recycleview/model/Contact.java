package com.example.recycleview.model;

public class Contact {

    //Deklarasi
    String nama;
    String email;
    int foto;

    //Constructor
    public Contact(int foto, String nama, String email) {
        this.nama = nama;
        this.email = email;
        this.foto = foto;
    }

    //Getter
    public String getNama() {
        return nama;
    }

    public String getEmail() {
        return email;
    }

    public int getFoto() {
        return foto;
    }
}
