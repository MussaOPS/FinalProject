package com.example.demo.Entity;

import javax.persistence.*;

@Entity
@Table(name = "UserType")
public class UserType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userTypeID;
    private String userTypeDescription;

    @OneToMany(mappedBy = "user")
    private User user;

}
