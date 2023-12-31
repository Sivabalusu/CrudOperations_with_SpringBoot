package com.practice.crudops.domain;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    //@id represents primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Species { class Animal, River
    //@GeneratedValue - Automatically generates value
    private int userId;
    private String firstName;
    private String lastName;
    private String email;

    public User() {
    }

    public User(int userId, String firstName, String lastName, String email) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }



    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
