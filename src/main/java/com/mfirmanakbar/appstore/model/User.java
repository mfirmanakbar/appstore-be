package com.mfirmanakbar.appstore.model;

import com.mfirmanakbar.appstore.helper.CustomJSONRootName;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "users")
@CustomJSONRootName(singular = "user", plural = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "missing name parameter")
    @NotBlank(message = "name can't be blank")
    private String name;

    @NotNull(message = "missing company parameter")
    @NotBlank(message = "company can't be blank")
    private String company;

    @NotNull(message = "missing phone number parameter")
    @NotBlank(message = "phone number can't be blank")
    private String phoneNumber;

    @Column(unique = true)
    @NotNull(message = "missing email parameter")
    @NotBlank(message = "email can't be blank")
    private String email;

    @NotNull(message = "missing password parameter")
    @NotBlank(message = "password can't be blank")
    private String password;

}