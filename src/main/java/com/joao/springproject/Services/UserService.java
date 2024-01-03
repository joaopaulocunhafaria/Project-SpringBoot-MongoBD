package com.joao.springproject.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joao.springproject.DTO.UserDto;
import com.joao.springproject.Services.Exceptions.ObjectNotFounException;
import com.joao.springproject.entites.User;
import com.joao.springproject.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFounException("Objeto não encontrado"));
	}

    public User insertUser(User obj){
        return repository.insert(obj);  
    }

    public User fromDto(UserDto usr){
        return new User(usr.getName(),usr.getId() ,usr.getEmail());
    }
}
