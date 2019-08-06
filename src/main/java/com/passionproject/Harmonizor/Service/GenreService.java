package com.passionproject.Harmonizor.Service;

import com.passionproject.Harmonizor.Model.Genre;
import com.passionproject.Harmonizor.Repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreService {
    @Autowired
    private GenreRepository genreRepository;

    public Genre create(Genre genre){ return genreRepository.save(genre);}

    public Iterable<Genre> findAll(){ return genreRepository.findAll();}
}
