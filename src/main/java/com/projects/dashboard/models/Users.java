package com.projects.dashboard.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "users")
@Entity
public class Users {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "pass")
    private String pass;

}
