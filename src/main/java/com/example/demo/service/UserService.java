package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service 
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> userAll(){
        return userRepository.findAll();
    }

    public ResponseEntity<?> saveEntry(User myEntry){
        userRepository.save(myEntry);
        return ResponseEntity.status(201).body(myEntry);
    }

    
}
