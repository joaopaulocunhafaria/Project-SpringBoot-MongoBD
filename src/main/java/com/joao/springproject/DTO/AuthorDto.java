package com.joao.springproject.DTO;

import java.io.Serializable;

import com.joao.springproject.entites.User;
import org.springframework.data.annotation.Id;

public class AuthorDto implements Serializable {
    private static final Long serialVersionUID = 1L;

    private String name;
    private String id;

    public AuthorDto(User usr) {
        this.name = usr.getName();
        this.id = usr.getId();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
