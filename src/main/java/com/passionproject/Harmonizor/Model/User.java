package com.passionproject.Harmonizor.Model;


import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
//@Table(name ="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String passwordHash;
    private String city;
    private String state;
    private String country;
    @ManyToMany
    @JoinTable(name = "user_instruments",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "instrument_id"))
    @ElementCollection
    private Set<Instrument> instruments;
    @ElementCollection
    private Set<Genre> genres;
    private String experienceLevel;



    public User() { }

    public User(String firstName, String lastName, String email, String passwordHash, Set<Instrument> instruments, Set<Genre> genres) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.passwordHash = passwordHash;
        this.instruments = instruments;
        this.genres = genres;
    }

    public User(Long id, String firstName, String lastName, String email, String passwordHash, Set<Instrument> instruments, Set<Genre> genres) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.passwordHash = passwordHash;
        this.instruments = instruments;
        this.genres = genres;
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

    public String getPasswordHash() { return passwordHash; }

    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }

    public Set<Instrument> getInstruments() {
        return instruments;
    }

    public void setInstruments(Set<Instrument> instruments) {
        this.instruments = instruments;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

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

    public String getExperienceLevel() {
        return experienceLevel;
    }

    public void setExperienceLevel(String experienceLevel) {
        this.experienceLevel = experienceLevel;
    }

    //    public enum experienceLevel{
//        BEGGINER,
//        INTERMEDIATE,
//        ADVANCED
//    }
}
