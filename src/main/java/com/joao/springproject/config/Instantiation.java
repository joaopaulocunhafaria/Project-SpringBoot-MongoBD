package com.joao.springproject.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.joao.springproject.DTO.AuthorDto;
import com.joao.springproject.DTO.CommentDto;
import com.joao.springproject.entites.Post;
import com.joao.springproject.entites.User;
import com.joao.springproject.repository.PostRepository;
import com.joao.springproject.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userReposiroty;

	@Autowired
	private PostRepository postReposiroty;

	@Override
	public void run(String... arg0) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		userReposiroty.deleteAll();
		postReposiroty.deleteAll();

		User maria = new User("Maria Brown", null, "maria@gmail.com");
		User alex = new User("Alex Green", null, "alex@gmail.com");
		User bob = new User("Bob Grey", null, "bob@gmail.com");

		userReposiroty.saveAll(Arrays.asList(maria, alex, bob));

		Post post1 = new Post("Partiu viagem", "Vou viajar para São Paulo. Abraços!",
				sdf.parse("21/03/2018"), new AuthorDto(maria));
		Post post2 = new Post("Bom dia", "Acordei feliz hoje!",
				sdf.parse("21/03/2018"), new AuthorDto(maria));

 		CommentDto c1 = new CommentDto("Boa viagem mano!", sdf.parse("21/03/2018"), new AuthorDto(alex));
		CommentDto c2 = new CommentDto("Aproveite", sdf.parse("22/03/2018"), new AuthorDto(bob));
		CommentDto c3 = new CommentDto("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new AuthorDto(alex));

		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().addAll(Arrays.asList(c3));
		postReposiroty.saveAll(Arrays.asList(post1, post2));
		maria.getPosts().add(post1);
		maria.getPosts().add(post2);
		userReposiroty.save(maria);

	}

}