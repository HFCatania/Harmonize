package com.passionproject.Harmonizor.Model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Instrument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long instrumentId;
    private String instrumentName;
    @ManyToMany(mappedBy = "user")
    private Set<User> users;

    public Instrument() {
    }

    public Instrument(String instrumentName, Set<User> users) {
        this.instrumentName = instrumentName;
        this.users = users;
    }

    public Instrument(Long instrumentId, String instrumentName, Set<User> users) {
        this.instrumentId = instrumentId;
        this.instrumentName = instrumentName;
        this.users = users;
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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
