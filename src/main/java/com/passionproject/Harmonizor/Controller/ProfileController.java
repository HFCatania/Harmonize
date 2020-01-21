package com.passionproject.Harmonizor.Controller;

import com.passionproject.Harmonizor.Model.Profile;
import com.passionproject.Harmonizor.Service.ProfileService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProfileController {

    private ModelMapper modelMapper;

    @Autowired
    ProfileService profileService;

    @CrossOrigin
    @PostMapping(path = "/profiles")
    public ResponseEntity<Profile> create(@RequestBody Profile profile){
        try{
            return new ResponseEntity<>(profileService.create(profile), HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/profiles/{id}")
    public ResponseEntity<Profile> getProfileById(@RequestParam Long id){
        try {
            return new ResponseEntity<>(profileService.findById(id), HttpStatus.FOUND);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/profiles")
    public ResponseEntity<Iterable<Profile>> findAll(){
        try {
            return new ResponseEntity<>(profileService.findAll(), HttpStatus.FOUND);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(path = "/profiles/{id}")
    public ResponseEntity<Profile> updateProfile(@PathVariable Long id, @RequestBody Profile profile){
        try{
            return new ResponseEntity<>(profileService.updateProfile(id, profile), HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
        }
    }
}
