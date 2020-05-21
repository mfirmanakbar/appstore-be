package com.mfirmanakbar.appstore.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mfirmanakbar.appstore.helper.CustomJSONRootName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "users")
@CustomJSONRootName(singular = "user", plural = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String company;

    @JsonProperty(value = "phone_number")
    private String phoneNumber;

    private String email;

    private String password;

    public User() {
    }

    @Builder
    public User(long id, String name, String company, String phoneNumber, String email, String password) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }

}