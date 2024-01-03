package com.joao.springproject.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.joao.springproject.entites.Post;

@Repository
public interface PostRepository extends MongoRepository<Post ,String> {
    
}
