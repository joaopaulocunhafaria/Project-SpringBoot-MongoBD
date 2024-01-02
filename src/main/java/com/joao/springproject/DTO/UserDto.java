package com.joao.springproject.DTO;

import java.io.Serializable;

import com.joao.springproject.entites.User;
import org.springframework.data.annotation.Id;

public class UserDto implements Serializable {
    


    private String name;
    private String id;
    private String email;

    public UserDto(){}
    public UserDto(User user){
        this.name=user.getName();
        this.email = user.getEmail();
        this.id = user.getId();

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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }



   

}
