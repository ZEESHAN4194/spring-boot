package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.UserService;
import com.example.demo.entity.User;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired 
    private UserService userService;

    // @GetMapping 
    // public List<> getuser(){

    // }
    
    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody User myData){
        // return ResponseEntity.status(201).body(userService.saveEntry(myData));
        return userService.saveEntry(myData);
    }
}