package com.mfirmanakbar.appstore.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserResponse {
    private String name;
    private String company;

    @JsonProperty("phone_number")
    private String phoneNumber;

    private String email;

    @Builder
    public UserResponse(String name, String company, String phoneNumber, String email) {
        this.name = name;
        this.company = company;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
