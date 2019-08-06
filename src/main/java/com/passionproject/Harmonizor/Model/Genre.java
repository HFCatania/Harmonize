package com.passionproject.Harmonizor.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "genres")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long genreId;
    private String genreName;
//    @ManyToMany(mappedBy = "user_genre")
//    @ElementCollection
//    private List<User> users = new ArrayList<>();

    public Genre() {
    }

    public Genre(Long genreId, String genreName, Set<User> users) {
        this.genreId = genreId;
        this.genreName = genreName;
    }

    public Long getGenreId() {
        return genreId;
    }

    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String name) {
        this.genreName = genreName;
    }

//    public List<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(List<User> users) {
//        this.users = users;
//    }
}
