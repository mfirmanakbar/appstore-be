package com.mfirmanakbar.appstore.validate;

import com.mfirmanakbar.appstore.request.UserRequest;
import com.mfirmanakbar.appstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserValidator {

    @Autowired
    private UserService userService;

    public List<String> validateSuccess(UserRequest userRequest) {
        ArrayList<String> errors = new ArrayList<>();

        if (userRequest.getName() == null) {
            errors.add("Name can't be null");
        }
        if (userRequest.getCompany() == null) {
            errors.add("Company can't be null");
        }
        if (userRequest.getPhoneNumber() == null) {
            errors.add("Phone Number can't be null");
        }
        if (userRequest.getEmail() == null) {
            errors.add("Email can't be null");
        }
        if (userRequest.getPassword() == null) {
            errors.add("Password can't be null");
        }
        if (userService.findByEmail(userRequest.getEmail()).getStatusCode() == HttpStatus.OK) {
            errors.add("Email already exist or registered");
        }

        return errors;
    }
}
