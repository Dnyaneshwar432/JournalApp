//package com.Project.JournalApp.JournalApp.Controller;
//
//import com.Project.JournalApp.JournalApp.Entities.ErrorResponse;
//import com.Project.JournalApp.JournalApp.Entities.JournalEntry;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/_api/journal")
//public class JournalEntryControllerV2 {
//
//    private Map<Long,JournalEntry> journalEntries = new HashMap<>();
//
//    @GetMapping
//    public ResponseEntity<?> getAll(){
//        List <JournalEntry> journalEntry = new ArrayList<>(journalEntries.values());
//
//        if(journalEntry.isEmpty())
//        {
//            return ResponseEntity.status(HttpStatus.OK).body("Oops Cart is Empty...");
//
//        }
//        return ResponseEntity.ok(journalEntry);
//
//    }
//
//    @GetMapping("id/{myId}")
//    public ResponseEntity<?> getJournalEntryById(@PathVariable Long myId){
//
//        if(!journalEntries.containsKey(myId))
//        {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("Data Not Found"));
//        }
//        JournalEntry journalData = journalEntries.get(myId);
//        return ResponseEntity.ok(journalData);
//
//    }
//
//    @PostMapping()
//    public boolean createEntry(@RequestBody JournalEntry myEntry){
//        journalEntries.put(myEntry.getId(),myEntry);
//
//        return true;
//    }
//
//
//    @DeleteMapping("id/{myId}")
//    public ResponseEntity<?> deleteJournalEntry(@PathVariable Long myId){
//
//        JournalEntry removeEntry = journalEntries.remove(myId);
//        if(removeEntry != null || journalEntries.containsKey(myId))
//        {
//            return ResponseEntity.ok(myId+" Deleted successfully..");
//        }else
//        {
//            return ResponseEntity.status(HttpStatus.OK).body("Journal Entry with id "+myId+" not found..");
//
//        }
//
//    }
//
//    @PutMapping("id/{myId}")
//    public JournalEntry updateJournalEntryById(@PathVariable Long myId,@RequestBody JournalEntry journalEntry){
//
//        //JournalEntry updateEntry = journalEntries.put(myId, journalEntry);
//
//
//        return journalEntries.put(myId, journalEntry);
//    }
//
//}
