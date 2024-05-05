package com.example.springbootassignment.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAuthResponse {
    private String token;
    private String userName;

    public UserAuthResponse(String token, String userName) {
        this.token = token;
        this.userName = userName;
    }
}
