package com.Project.JournalApp.JournalApp.Services;

import com.Project.JournalApp.JournalApp.Entities.JournalEntry;
import com.Project.JournalApp.JournalApp.Repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;


    public void saveJournal(JournalEntry journalEntry)
    {
        journalEntryRepository.save(journalEntry);
    }

    public List<JournalEntry> getAllEntries()
    {
        return journalEntryRepository.findAll();

    }

    public Optional<JournalEntry> findById(ObjectId id)
    {
        return journalEntryRepository.findById(id);
    }

    public List<JournalEntry> findByTitle(String title)
    {
        return journalEntryRepository.findByTitle(title);
    }

    public void deleteById(ObjectId id)
    {
        journalEntryRepository.deleteById(id);
    }

    public void deleteAll(){
        journalEntryRepository.deleteAll();
    }



}
