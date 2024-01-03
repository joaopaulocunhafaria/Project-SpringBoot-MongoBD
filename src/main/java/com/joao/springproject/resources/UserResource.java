package com.joao.springproject.resources;

import java.net.URI;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.joao.springproject.DTO.UserDto;
import com.joao.springproject.Services.UserService;
import com.joao.springproject.entites.Post;
import com.joao.springproject.entites.User;

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

    @PostMapping
    public ResponseEntity<Void> postUser(@RequestBody UserDto user) {
        User newUser = service.fromDto(user);
        newUser = service.insertUser(newUser);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getId())
                .toUri();
        return ResponseEntity.created(uri).build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable String id) {
        return ResponseEntity.ok().body(service.deleteUser(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUser(@RequestBody UserDto usr, @PathVariable String id) {
        User userToBeUpdate = service.fromDto(usr);
        userToBeUpdate.setId(id);
        service.updateUser(userToBeUpdate);
        return ResponseEntity.noContent().build();

    }

    @RequestMapping(value = "/{id}/posts", method = RequestMethod.GET)
    public ResponseEntity<Set<Post>> findPosts(@PathVariable String id) {
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj.getPosts());
    }

}
