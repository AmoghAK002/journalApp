package com.amogh.journalApp.repository;

import com.amogh.journalApp.entity.JournalEntry;
import com.amogh.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {

    User findByUsername(String username);
}