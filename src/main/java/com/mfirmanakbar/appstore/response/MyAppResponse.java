package com.mfirmanakbar.appstore.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyAppResponse {

    private long id;
    private String name;
    private String description;
    private UserResponse userResponse;

    public MyAppResponse() {
    }

    @Builder
    public MyAppResponse(long id, String name, String description, UserResponse userResponse) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.userResponse = userResponse;
    }
}
