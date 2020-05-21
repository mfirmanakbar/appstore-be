package com.mfirmanakbar.appstore.request;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mfirmanakbar.appstore.helper.CustomJSONRootName;
import com.mfirmanakbar.appstore.model.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
public class MyAppRequest {

    private long id;
    private String name;
    private String description;

    @JsonProperty("user_id")
    private long userId;

    public MyAppRequest() {
    }

    @Builder
    public MyAppRequest(long id, String name, String description, long userId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.userId = userId;
    }
}
