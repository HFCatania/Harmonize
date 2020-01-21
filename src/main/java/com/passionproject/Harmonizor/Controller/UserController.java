package com.passionproject.Harmonizor.Controller;

import com.passionproject.Harmonizor.DTO.UserDataDTO;
import com.passionproject.Harmonizor.DTO.UserResponseDTO;
import com.passionproject.Harmonizor.Model.CreateUser;
import com.passionproject.Harmonizor.Model.User;
import com.passionproject.Harmonizor.Service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
//@RequestMapping(value = "/api")
@CrossOrigin(origins ="*", allowedHeaders = "*")
public class UserController {

    private ModelMapper modelMapper;
    UserService userService;

    @Autowired
    public UserController(ModelMapper modelMapper, UserService userService){
        this.modelMapper = modelMapper;
        this.userService = userService;
    }


    @PostMapping(path="/users")
    public ResponseEntity<User> create(@RequestBody CreateUser user){
        try{
            return new ResponseEntity<>(userService.create(user), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path="/users")
    public ResponseEntity<Iterable<User>> findAll(){
        try{
            return new ResponseEntity<Iterable<User>>(userService.findAll(), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path="/login")
    @ResponseStatus(HttpStatus.CREATED)
    public String login(@RequestParam String email, @RequestParam String password){
        return userService.logIn(email, password);
    }

    @PostMapping(path = "/register")
    @ResponseStatus(HttpStatus.CREATED)
    public String register(@RequestBody UserDataDTO user){
        return userService.registerUser(modelMapper.map(user, User.class));
    }

    @GetMapping(value = "/me")
    public UserResponseDTO whoami(HttpServletRequest req){
        return modelMapper.map(userService.whoami(req), UserResponseDTO.class);
    }



}
