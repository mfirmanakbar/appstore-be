package com.mfirmanakbar.appstore.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mfirmanakbar.appstore.model.MyApp;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class UserResponse {
    private String name;
    private String company;

    @JsonProperty("phone_number")
    private String phoneNumber;

    private String email;

    @JsonProperty("myapps")
    private List<MyApp> myApps;

    @Builder
    public UserResponse(String name, String company, String phoneNumber, String email) {
        this.name = name;
        this.company = company;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    @Builder
    public UserResponse(String name, String company, String phoneNumber, String email, List<MyApp> myApps) {
        this.name = name;
        this.company = company;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.myApps = myApps;
    }
}
