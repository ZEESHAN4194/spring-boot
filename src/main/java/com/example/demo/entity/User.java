package com.example.demo.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
@Document( collection = "users")
public class User {

    @Id 
    private ObjectId id;

    @Indexed (unique = true)
    private String name;
    private String password;
    private String journalEntries;

    
}
