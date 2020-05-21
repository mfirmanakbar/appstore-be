package com.mfirmanakbar.appstore.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class MyAppController {

    @RequestMapping(value = "/myapp", method = RequestMethod.GET)
    public String index() {
        return "GET My App";
    }

}
