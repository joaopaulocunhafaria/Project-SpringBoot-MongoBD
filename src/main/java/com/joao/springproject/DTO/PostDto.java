package com.joao.springproject.DTO;

import java.io.Serializable;

import com.joao.springproject.entites.Post;
import org.springframework.data.annotation.Id;

public class PostDto implements Serializable {
    private static final Long serialVersionUID = 1L;

    private String id;
    private String userName;


    public PostDto(){}

    public PostDto(Post  post){
        this.id=post.getId();
        this.userName=post.getAuthor().getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    

}
