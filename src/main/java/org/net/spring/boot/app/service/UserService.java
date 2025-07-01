package org.net.spring.boot.app.service;

import org.bson.types.ObjectId;
import org.net.spring.boot.app.entity.JournalEntry;
import org.net.spring.boot.app.entity.User;
import org.net.spring.boot.app.repository.JournalEntryRepository;
import org.net.spring.boot.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveEntry(User user){
        userRepository.save(user);
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public Optional<User> findById(ObjectId id){
        return userRepository.findById(id);
    }

    public void deleteById(ObjectId id){
        userRepository.deleteById(id);
    }

    public User findByUserName(User user){
        return userRepository.findByUserName(user);
    }
}
