package com.example.users.service;

import com.example.users.model.User;
import com.example.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User createUser(User user) {
        return repository.save(user);
    }

    public User updateUser(Long id, User user) {
        return repository.findById(id).map(existingUser -> {
            existingUser.setNome(user.getNome());
            existingUser.setEmail(user.getEmail());
            return repository.save(existingUser);
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }
}
