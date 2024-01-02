package com.joao.springproject.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.joao.springproject.entites.User;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
    
}
