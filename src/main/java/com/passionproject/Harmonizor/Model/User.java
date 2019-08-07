package com.passionproject.Harmonizor.Model;


import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name ="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String city;
    private String state;
    private String country;
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "user_instruments",
//                joinColumns = @JoinColumn(name = "user_id"),
//                inverseJoinColumns = @JoinColumn(name = "instrument_id"))
//    @ElementCollection
//    private List<Instrument> instruments = new ArrayList<>();
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "user_genre",
//                joinColumns = @JoinColumn(name = "user_id"),
//                inverseJoinColumns = @JoinColumn(name = "genre_id"))
//    @ElementCollection
//    private List<Genre> genres = new ArrayList<>();
//    private String experienceLevel;



    public User() { }

    public User(String firstName, String lastName, String email, String password, List<Instrument> instruments, List<Genre> genres) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
//        this.instruments = instruments;
//        this.genres = genres;
    }

    public User(Long id, String firstName, String lastName, String email, String password, List<Instrument> instruments, List<Genre> genres) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
//        this.instruments = instruments;
//        this.genres = genres;
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

//    public List<Instrument> getInstruments() {
//        return instruments;
//    }
//
//    public void setInstruments(List<Instrument> instruments) {
//        this.instruments = instruments;
//    }
//
//    public List<Genre> getGenres() {
//        return genres;
//    }
//
//    public void setGenres(List<Genre> genres) {
//        this.genres = genres;
//    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }


    public void setCountry(String country) {
        this.country = country;
    }
//
//    public String getExperienceLevel() {
//        return experienceLevel;
//    }
//
//    public void setExperienceLevel(String experienceLevel) {
//        this.experienceLevel = experienceLevel;
//    }

    //    public enum experienceLevel{
//        BEGGINER,
//        INTERMEDIATE,
//        ADVANCED
//    }
}
