package com.mfirmanakbar.appstore.service;

import com.mfirmanakbar.appstore.helper.CustomJSONRootName;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    Map mapResult = new HashMap();

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
                mapResult = new HashMap();
                mapResult.put(User.class.getAnnotation(CustomJSONRootName.class).singular(), userConvert.userToUserResponse(user));
                return new ResponseEntity<>(mapResult, HttpStatus.CREATED);
            }
            return new ResponseEntity<>(new CommonResponse("internal server error"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> findByEmail(String email) {
        User user;
        user = userRepository.findByEmail(email);
        if (user != null) {
            mapResult = new HashMap();
            mapResult.put(User.class.getAnnotation(CustomJSONRootName.class).singular(), userConvert.userToUserResponse(user));
            return new ResponseEntity<>(mapResult, HttpStatus.OK);
        }
        return new ResponseEntity<>(new CommonResponse("email user not found"), HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<?> findById(long id) {
        User user;
        user = userRepository.findById(id).get();
        if (user != null) {
            mapResult = new HashMap();
            mapResult.put(User.class.getAnnotation(CustomJSONRootName.class).singular(), userConvert.userToUserV2Response(user));
            return new ResponseEntity<>(mapResult, HttpStatus.OK);
        }
        return new ResponseEntity<>(new CommonResponse("email user not found"), HttpStatus.NOT_FOUND);
    }
}
