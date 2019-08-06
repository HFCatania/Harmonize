package com.passionproject.Harmonizor.Model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "instruments")
public class Instrument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long instrumentId;
    private String instrumentName;
//    @ManyToMany(mappedBy = "user_instrument")
//    @ElementCollection
//    private List<User> users = new ArrayList<>();

    public Instrument() {
    }

    public Instrument(String instrumentName, List<User> users) {
        this.instrumentName = instrumentName;
//        this.users = users;
    }

    public Instrument(Long instrumentId, String instrumentName, List<User> users) {
        this.instrumentId = instrumentId;
        this.instrumentName = instrumentName;
//        this.users = users;
    }

    public Long getInstrumentId() {
        return instrumentId;
    }

    public void setInstrumentId(Long instrumentId) {
        this.instrumentId = instrumentId;
    }

    public String getInstrumentName() {
        return instrumentName;
    }

    public void setInstrumentName(String instrumentName) {
        this.instrumentName = instrumentName;
    }


    }

//    public List<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(List<User> users) {
//        this.users = users;
//    }

