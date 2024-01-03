package com.joao.springproject.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.joao.springproject.DTO.UserDto;
import com.joao.springproject.Services.UserService;
import com.joao.springproject.entites.User;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserDto>> findAll() {

        List<User> users = service.findAll();
        List<UserDto> usersDto = users.stream().map(x -> new UserDto(x)).toList();

        return ResponseEntity.ok().body(usersDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable String id) {

        User usr = service.findById(id);

        UserDto usrDto = new UserDto(usr);

        return ResponseEntity.ok().body(usrDto);
    }

}
