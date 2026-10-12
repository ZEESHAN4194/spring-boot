package com.example.demo.entity;

import java.time.LocalDateTime;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
// import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString 
@Document(collection = "journal_entries")
public class JournalEntry {

    @Id
    private ObjectId id;

    // @Indexed (unique = true)
    private String name;
    
    private String content;

    private String userId;

    private LocalDateTime date;
    
}
