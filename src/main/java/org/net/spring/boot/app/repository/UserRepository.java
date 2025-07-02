package org.net.spring.boot.app.repository;

import org.bson.types.ObjectId;
import org.net.spring.boot.app.entity.JournalEntry;
import org.net.spring.boot.app.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {
    User findByUserName(String userName);
}
