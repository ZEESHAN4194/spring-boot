package com.example.demo.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.JournalEntry;
import com.example.demo.repository.JournalEntryRepository;

@Service 
public class JournalEntryService {

    @Autowired 
    private JournalEntryRepository journalEntryRepository;

    public JournalEntry saveEntry(JournalEntry myEntry){
        myEntry.setUserId("test123");
        return journalEntryRepository.save(myEntry);
    }

    public List<JournalEntry> getEntry(){
        return journalEntryRepository.findAll();
    }

    public JournalEntry getDataById(ObjectId myId){
        return journalEntryRepository.findById(myId).orElse(null);
    }

    public void deleteById(ObjectId myId){
        journalEntryRepository.deleteById(myId);
    }

    public JournalEntry updateById(ObjectId myId, JournalEntry updateData) {    

        JournalEntry existingEntry = journalEntryRepository.findById(myId)
                                     .orElseThrow(()-> new RuntimeException("not found"));
        existingEntry.setName(updateData.getName());
        existingEntry.setContent(updateData.getContent());
        return journalEntryRepository.save(existingEntry);
                    
    }
    
}
