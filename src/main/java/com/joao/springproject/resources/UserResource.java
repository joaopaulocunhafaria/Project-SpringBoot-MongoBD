package com.joao.springproject.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joao.springproject.entites.User;

@RestController
public class UserResource {

    @GetMapping("/users")
    public ResponseEntity<List<User>> findAll() {
       User joao = new User("Joao", "1", "joao@gmail.com");
         User maria = new User("Maria", "2", "maria@gmail.com");
         List<User> list = List.of(joao, maria);
         return ResponseEntity.ok().body(list);
    }

}
