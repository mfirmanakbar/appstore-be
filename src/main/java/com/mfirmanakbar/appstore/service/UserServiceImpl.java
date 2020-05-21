package com.mfirmanakbar.appstore.service;

import com.mfirmanakbar.appstore.model.User;
import com.mfirmanakbar.appstore.repository.UserRepository;
import com.mfirmanakbar.appstore.request.UserRequest;
import com.mfirmanakbar.appstore.response.CommonResponse;
import com.mfirmanakbar.appstore.converter.UserConvert;
import com.mfirmanakbar.appstore.validate.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    JwtUserDetailsService jwtUserDetailsService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private UserConvert userConvert;

    @Override
    public ResponseEntity<?> save(UserRequest userRequest) {
        List<String> errors = userValidator.validateSuccess(userRequest);
        if (errors.size() > 0) {
            return new ResponseEntity<>(new CommonResponse(errors.toString()), HttpStatus.BAD_REQUEST);
        } else {
            userRequest.setPassword(jwtUserDetailsService.encodeUserPassword(userRequest.getPassword()));
            User user = userConvert.userRequestToUser(userRequest);
            user = userRepository.save(user);
            if (user.getId() > 0) {
                return new ResponseEntity<>(userConvert.userToUserResponse(user), HttpStatus.CREATED);
            }
            return new ResponseEntity<>(userRequest, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> findByEmail(String email) {
        User user;
        user = userRepository.findByEmail(email);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(new CommonResponse("email user not found"), HttpStatus.NOT_FOUND);
    }
}
