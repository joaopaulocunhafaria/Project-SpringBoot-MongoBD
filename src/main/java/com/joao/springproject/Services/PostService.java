package com.joao.springproject.Services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joao.springproject.Services.Exceptions.ObjectNotFounException;
import com.joao.springproject.entites.Post;
import com.joao.springproject.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFounException("Objeto não encontrado"));
	}

	public List<Post> findByTitle(String text) {
        return repo.searchTitle(text);
		//return repo.findByTitleContainingIgnoreCase(text);
	}

	public List<Post> fullSearch(String  text, Date min, Date max){
		max =  new Date ( max.getTime()+24*60*60*1000	);
         return repo.fullSearch(text, min, max);
 
	}
}