package com.passionproject.Harmonizor.Model;


import com.fasterxml.jackson.annotation.JsonManagedReference;


import javax.persistence.*;


@Entity
@Table(name ="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @JsonManagedReference
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    private Profile profile;
    private String Token;



    public User() { }

    public User(String firstName, String lastName, String email, String password, Profile profile) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.profile = profile;
    }

    public User(Long id, String firstName, String lastName, String email, String password, Profile profile) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.profile = profile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile Profile) {
        this.profile = profile;
    }

    public String getToken() { return Token; }

    public void setToken(String token) { Token = token; }

    //    public enum experienceLevel{
//        BEGGINER,
//        INTERMEDIATE,
//        ADVANCED
//    }
}
