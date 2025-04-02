package com.Project.JournalApp.JournalApp.Repository;

import com.Project.JournalApp.JournalApp.Entities.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface JournalEntryRepository extends MongoRepository<JournalEntry, ObjectId>  {
    List<JournalEntry> findByTitle(String title);
}
