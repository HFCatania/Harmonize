package com.passionproject.Harmonizor.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", nullable = false)
    private User user;
    private String city;
    private String state;
    private String country;
    private Integer zipcode;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "profile_instruments",
                joinColumns = @JoinColumn(name = "profile_id"),
                inverseJoinColumns = @JoinColumn(name = "instrument_id"))
    @ElementCollection
    private List<Instrument> instruments = new ArrayList<>();
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "profile_genre",
                joinColumns = @JoinColumn(name = "profile_id"),
                inverseJoinColumns = @JoinColumn(name = "genre_id"))
    @ElementCollection
    private List<Genre> genres = new ArrayList<>();
    private String experienceLevel;
}
