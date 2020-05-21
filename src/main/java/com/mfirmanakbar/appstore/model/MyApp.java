package com.mfirmanakbar.appstore.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mfirmanakbar.appstore.helper.CustomJSONRootName;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "myapps")
@CustomJSONRootName(singular = "myapp", plural = "myapps")
public class MyApp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String description;

    @JsonProperty("user_id")
    private long userId;

    public MyApp() {
    }

    public MyApp(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
