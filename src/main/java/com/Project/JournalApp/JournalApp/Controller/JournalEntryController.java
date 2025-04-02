package com.Project.JournalApp.JournalApp.Controller;

import com.Project.JournalApp.JournalApp.Entities.ErrorResponse;
import com.Project.JournalApp.JournalApp.Entities.JournalEntry;
import com.Project.JournalApp.JournalApp.Services.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/journal")
public class JournalEntryController {

    @Autowired
    private JournalEntryService journalEntryService;

    @PostMapping()
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myEntry){
      try {
          myEntry.setDate(LocalDateTime.now());
          journalEntryService.saveJournal(myEntry);
          return new ResponseEntity<>(myEntry,HttpStatus.CREATED);
      }catch (Exception e)
      {
          return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

      }
    }

    @GetMapping
    public ResponseEntity<List<JournalEntry>> getAll(){

       List<JournalEntry> journalEntry =  journalEntryService.getAllEntries();
       if(journalEntry.isEmpty())
       {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
       else {
           return new ResponseEntity<>(journalEntry,HttpStatus.OK);
       }
    }

    @GetMapping("id/{myId}")
    public ResponseEntity<JournalEntry> getJournalEntryById(@PathVariable ObjectId myId){
        Optional<JournalEntry> journalEntry = journalEntryService.findById(myId);
        if(journalEntry.isPresent())
        {
            return new ResponseEntity<>(journalEntry.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("title/{title}")
    public ResponseEntity<List<JournalEntry>> getJournalEntryByTitle(@PathVariable String title){

        List<JournalEntry> byTitle = journalEntryService.findByTitle(title);
        if(byTitle.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return  new ResponseEntity<>(byTitle,HttpStatus.OK);
        }

    }
    @DeleteMapping("id/{myId}")
    public boolean deleteJournalEntry(@PathVariable ObjectId myId){

        journalEntryService.deleteById(myId);
        return true;
    }

    @PutMapping("id/{myId}")
    public ResponseEntity<JournalEntry> updateJournalEntryById(@PathVariable ObjectId myId,@RequestBody JournalEntry newEntry){
       JournalEntry findEntry =  journalEntryService.findById(myId).orElse(null);
       if(findEntry != null)
       {
           findEntry.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals("")? newEntry.getTitle() : findEntry.getTitle());
           findEntry.setContent(newEntry.getContent() != null && !newEntry.getContent().equals("")? newEntry.getContent() : findEntry.getContent());
           journalEntryService.saveJournal(newEntry);
           return new ResponseEntity<>(findEntry,HttpStatus.OK);
       }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteAll")
    public boolean deleteAllEntry(){
        journalEntryService.deleteAll();
        return true;
    }


}
