package com.mfirmanakbar.appstore.converter;

import com.mfirmanakbar.appstore.model.User;
import com.mfirmanakbar.appstore.request.UserRequest;
import com.mfirmanakbar.appstore.response.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserConvert {

    public User userRequestToUser(UserRequest userRequest) {
        return User.builder()
                .id(userRequest.getId())
                .name(userRequest.getName())
                .company(userRequest.getCompany())
                .phoneNumber(userRequest.getPhoneNumber())
                .email(userRequest.getEmail())
                .password(userRequest.getPhoneNumber())
                .build();
    }

    public UserResponse userToUserResponse(User user) {
        return UserResponse.builder()
                .name(user.getName())
                .company(user.getCompany())
                .phoneNumber(user.getPhoneNumber())
                .email(user.getEmail())
                .build();
    }

}
