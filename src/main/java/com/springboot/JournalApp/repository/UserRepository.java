package com.springboot.JournalApp.repository;

import com.springboot.JournalApp.entity.JournalEntry;
import com.springboot.JournalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, ObjectId> {


    User findByUserName(String userName);

    void deleteByUserName(String userName);
}
