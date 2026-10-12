package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.JournalEntry;
import com.example.demo.service.JournalEntryService;

@RestController 
@RequestMapping("journal")
public class JournalEntryControllerV2 {

    @Autowired
    private JournalEntryService journalEntryService;
    private static final Logger logger = LoggerFactory.getLogger(JournalEntryControllerV2.class);


    @PostMapping 
    public ResponseEntity<JournalEntry> addData(@RequestBody JournalEntry myEntry){ 
        myEntry.setDate(LocalDateTime.now());
        JournalEntry savedEntry = journalEntryService.saveEntry(myEntry);
        return ResponseEntity.status(201).body(savedEntry);
    }

    @GetMapping 
    public ResponseEntity<List<JournalEntry>> getData(){
       return ResponseEntity.status(200).body(journalEntryService.getEntry());
    }

    @GetMapping("/id/{myId}") 
    public ResponseEntity<JournalEntry> getDataById(@PathVariable ObjectId myId){
        // return journalEntryService.getDataById(myId);
        return ResponseEntity.status(200).body(journalEntryService.getDataById(myId));
    }

    @DeleteMapping("/id/{myId}")
    public void deleteId(@PathVariable ObjectId myId){
        journalEntryService.deleteById(myId);
    }

    @PutMapping("/id/{myId}")
    public JournalEntry updateById(@PathVariable ObjectId myId, @RequestBody JournalEntry updateData){
            return journalEntryService.updateById(myId,updateData);
    }

}