package me.zilzustudy.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class User {


    private Integer id;
    private String name;
    private String email;
    private String username;
    private String phone;
    private String website;
    private Address address;
    @JsonIgnore
    private Company company;


    // get zilzu info
    public User(Integer id, String name, String email, String username, String phone, String website, Address address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.username = username;
        this.phone = phone;
        this.website = website;
        this.address = address;
    }

    public User() {
    }
}
