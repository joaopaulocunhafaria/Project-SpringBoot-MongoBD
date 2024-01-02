package com.joao.springproject.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joao.springproject.DTO.UserDto;
import com.joao.springproject.Services.UserService;
import com.joao.springproject.entites.User;

@RestController
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> findAll() {
         
         List<User> users = service.findAll();
         List<UserDto> usersDto = users.stream().map(x -> new UserDto(x)).toList();

        return ResponseEntity.ok().body(usersDto);
    }

}
