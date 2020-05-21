package com.mfirmanakbar.appstore.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class JwtRequest implements Serializable {

    private static final long serialVersionUID = 5926468583005150707L;

    private String email;
    private String password;

    public JwtRequest() {
    }

    @Builder
    public JwtRequest(String email, String password) {
        this.setEmail(email);
        this.setPassword(password);
    }

}