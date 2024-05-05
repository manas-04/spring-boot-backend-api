package com.example.springbootassignment.api.controller;

import com.example.springbootassignment.api.helper.JWTHelper;
import com.example.springbootassignment.api.model.ErrorResponse;
import com.example.springbootassignment.api.model.UserAuthResponse;
import com.example.springbootassignment.api.model.UserLogin;
import com.example.springbootassignment.api.model.Users;
import com.example.springbootassignment.service.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Arrays;

@Controller
public class UsersController {

    Logger logger = LoggerFactory.getLogger(UsersController.class.getName());

    final JWTHelper jwtHelper = new JWTHelper();

    @Autowired
    private UsersService usersService;

    @PostMapping("/signup")
    public ResponseEntity<Object> signup(@RequestBody UserLogin users) {
        try {
            if (users.getUserName() == null || users.getUserName().isBlank()) {
                return ResponseEntity.badRequest().body(new ErrorResponse("Username is required"));
            }
            if (users.getPassword() == null || users.getPassword().isBlank()) {
                return ResponseEntity.badRequest().body( new ErrorResponse("Password is required"));
            }
            return ResponseEntity.ok(this.usersService.save(users.getUserName(), users.getPassword()));
        } catch (Exception e) {
            logger.info(Arrays.toString(e.getStackTrace()));
            return ResponseEntity.internalServerError().body(new ErrorResponse("An error occurred"));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody UserLogin user) {
        try {
            if (user.getUserName() == null || user.getUserName().isBlank()) {
                return ResponseEntity.badRequest().body(new ErrorResponse("Username is required"));
            }
            if (user.getPassword() == null || user.getPassword().isBlank()) {
                return ResponseEntity.badRequest().body( new ErrorResponse("Password is required"));
            }

            Users existingUser = this.usersService.findByUserName(user.getUserName());
            Boolean isVerified = Users.doesPasswordMatch(user, existingUser.getPassword());

            if (isVerified) {
                String token = this.jwtHelper.generateToken(existingUser);
                UserAuthResponse response = new UserAuthResponse(token, user.getUserName());
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                String errorMessage = "User verification failed";
                logger.error(errorMessage);
                throw new IllegalArgumentException(errorMessage);
            }
        } catch (Exception e) {
            logger.info(Arrays.toString(e.getStackTrace()));
            return ResponseEntity.internalServerError().body(new ErrorResponse("An error occurred"));
        }
    }

}
