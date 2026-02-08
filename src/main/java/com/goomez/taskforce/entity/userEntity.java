package com.goomez.taskforce.entity;

import jakarta.persistence.*;

@Entity
public class userEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "username",  unique = true,nullable = false,length = 500)
    private String username;
    @Column(name = "email", unique = true,nullable = false,length = 500)
    private String email;
    @Column(name = "password", unique = true,nullable = false,length = 500)
    private String password;
    @Column(name = "sexo",nullable = false,length = 500)
    private String sexo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
