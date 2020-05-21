package com.mfirmanakbar.appstore.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRequest {
    private long id;
    private String name;
    private String company;

    @JsonProperty("phone_number")
    private String phoneNumber;

    private String email;
    private String password;
}
