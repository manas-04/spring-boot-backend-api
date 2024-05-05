package com.example.springbootassignment.api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Getter
@Setter
@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(unique = true)
    private String userName;
    private String password;
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public Users() {}

    public Users(String userName, String password) {
        this.userName = userName;
        this.password = encryptPassword(password);
    }

    public void setPassword(String password) {
        this.password = encryptPassword(password);
    }

    public static String encryptPassword(String password) {
        return encoder.encode(password);
    }

    public static Boolean doesPasswordMatch(UserLogin user, String encodedPassword) {
        return encoder.matches(user.getPassword(), encodedPassword);
    }
}