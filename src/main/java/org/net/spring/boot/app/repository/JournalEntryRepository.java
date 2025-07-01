package org.net.spring.boot.app.repository;

import org.bson.types.ObjectId;
import org.net.spring.boot.app.entity.JournalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalEntryRepository extends MongoRepository<JournalEntry, ObjectId> {

}
