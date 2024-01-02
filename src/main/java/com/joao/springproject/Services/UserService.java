package com.joao.springproject.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joao.springproject.entites.User;
import com.joao.springproject.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;
    
    public List<User> findAll() {
       return repository.findAll();
    }
}
