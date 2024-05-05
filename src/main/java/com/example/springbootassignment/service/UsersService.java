package com.example.springbootassignment.service;

import com.example.springbootassignment.Repository.UsersRepository;
import com.example.springbootassignment.api.model.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    @Autowired
    private final UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository repo) {
        this.usersRepository = repo;
    }

    public Users findByUserId(Long id){
        return usersRepository.findByUserId(id);
    }

    public Users save(String name, String password){
        Users user = new Users(name, password);
        return usersRepository.save(user);
    }

    public Users findByUserName(String name){
        return usersRepository.findByUserName(name);
    }
}
