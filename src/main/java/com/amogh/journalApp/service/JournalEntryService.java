package com.amogh.journalApp.service;

import com.amogh.journalApp.entity.JournalEntry;
import com.amogh.journalApp.entity.User;
import com.amogh.journalApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Autowired
    private UserService userService;

    public void saveEntry(JournalEntry journalEntry, String usernmae) {
        User user = userService.findByUsername(usernmae);
        JournalEntry saved = journalEntryRepository.save(journalEntry);
        user.getJournalEntries().add(saved);
        userService.saveEntry(user);
    }

    public List<JournalEntry> getAll(){
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> findById(ObjectId id){
        return journalEntryRepository.findById(id);
    }

    public void deleteById(ObjectId id, String username){
        User user = userService.findByUsername(username);
        user.getJournalEntries().removeIf(x -> x.getId().equals(id)); //If we comment this line out and try to delete the journal entry it gets deleted in the journal_entries collection but again the reference is still in users collection BUT if we try out POST call in the postman the new entry is created and the old entry is gone and the consistency is achieved -->IMP
        userService.saveEntry(user);
        journalEntryRepository.deleteById(id);
    }
}