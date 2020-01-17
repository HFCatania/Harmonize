package com.passionproject.Harmonizor.Controller;

import com.passionproject.Harmonizor.Model.Genre;
import com.passionproject.Harmonizor.Service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "http://localhost:4200")
public class GenreController {
    @Autowired
    private GenreService genreService;

    @PostMapping(path = "/genres")
    public ResponseEntity<Genre> create(@RequestBody Genre genre){
        try {
            return new ResponseEntity<>(genreService.create(genre), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/genres")
    public ResponseEntity<Iterable<Genre>> findAll(){
        try {
            return new ResponseEntity<>(genreService.findAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
