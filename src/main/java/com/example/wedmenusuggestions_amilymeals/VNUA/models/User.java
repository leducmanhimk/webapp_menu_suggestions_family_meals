package com.example.wedmenusuggestions_amilymeals.VNUA.models;


import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {
    public User(){

    }
    public User(Long id, String fistname, String lastname, String username, String password, String useremail) {
        Id = id;
        this.fistname = fistname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.useremail = useremail;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(name = "fistname",length = 30)
    private String fistname;

    @Column(name = "lastname",length = 30)
    private String lastname;

    @Column(name = "username",length = 40)
    private String username;

    @Column(name = "password",length = 100)
    private String password;

    @Column(name = "email",length = 100)
    private String useremail;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getFistname() {
        return fistname;
    }

    public void setFistname(String fistname) {
        this.fistname = fistname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }
}
