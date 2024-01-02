package com.joao.springproject.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.joao.springproject.entites.User;
import com.joao.springproject.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

   @Autowired
   private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
       
        userRepository.deleteAll();

       User joao = new User("João Paulo", null,"joaopaulo@gmail.com");
       User elaine = new User("Elaine Patricia", null,"elain@gmail.com");

        userRepository.saveAll(Arrays.asList(joao,elaine));


    }
    
}
