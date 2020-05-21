package com.mfirmanakbar.appstore.service;

import com.mfirmanakbar.appstore.request.UserRequest;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<?> save(UserRequest userRequest);

    ResponseEntity<?> findByEmail(String email);
}
