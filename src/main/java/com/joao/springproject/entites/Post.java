package com.joao.springproject.entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.joao.springproject.DTO.AuthorDto;
import com.joao.springproject.DTO.CommentDto;

@Document
public class Post implements Serializable {
    private static final Long serialVersionUID = 1L;
    @Id
    private String id;
    private String body;
    private String title;
    private Date date;
    private AuthorDto author;
    private List<CommentDto> comments  = new ArrayList<>();

    public Post() {
    }


    

    public Post( String body, String title, Date date, AuthorDto author) {
       
        this.body = body;
        this.title = title;
        this.date = date;
        this.author = author;
    }







    public List<CommentDto> getComments() {
        return comments;
    }




    public void setComments(List<CommentDto> comments) {
        this.comments = comments;
    }




    public AuthorDto getAuthor() {
        return author;
    }




    public void setAuthor(AuthorDto author) {
        this.author = author;
    }




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)                        
            return false;
        if (getClass() != obj.getClass())
            return false;
        Post other = (Post) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
