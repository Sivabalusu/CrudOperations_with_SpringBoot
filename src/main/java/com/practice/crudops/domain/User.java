package com.practice.crudops.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user")
public class User {

    @Id
    //@id represents primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue - Automatically generates value
    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private Role role;
    private String password;

}


