package com.passionproject.Harmonizor.Controller;

import com.passionproject.Harmonizor.Model.User;
import com.passionproject.Harmonizor.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value="/users")
    public ResponseEntity<User> create(@RequestBody User user){
        try{
            return new ResponseEntity<>(userService.create(user), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
