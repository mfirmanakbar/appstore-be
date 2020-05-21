package com.mfirmanakbar.appstore.controller;

import com.mfirmanakbar.appstore.request.JwtRequest;
import com.mfirmanakbar.appstore.request.UserRequest;
import com.mfirmanakbar.appstore.response.CommonResponse;
import com.mfirmanakbar.appstore.response.JwtResponse;
import com.mfirmanakbar.appstore.security.JwtTokenUtil;
import com.mfirmanakbar.appstore.service.JwtUserDetailsService;
import com.mfirmanakbar.appstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> register(@RequestBody UserRequest userRequest) {
        return userService.save(userRequest);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        String authenticate = authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());
        if (authenticate != null) {
            return new ResponseEntity<>(new CommonResponse("Email or Password Invalid"), HttpStatus.UNAUTHORIZED);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmail());
        if (userDetails == null) {
            return new ResponseEntity<>(new CommonResponse("Email or Password wrong"), HttpStatus.UNAUTHORIZED);
        }

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    private String authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            return null;
        } catch (DisabledException e) {
            // throw new Exception("USER_DISABLED", e);
            return "USER_DISABLED " + e.getMessage();
        } catch (BadCredentialsException e) {
            // throw new Exception("INVALID_CREDENTIALS", e);
            return "INVALID_CREDENTIALS " + e.getMessage();
        }
    }
}
