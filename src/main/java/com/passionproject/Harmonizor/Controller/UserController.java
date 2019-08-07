package com.passionproject.Harmonizor.Controller;

import com.passionproject.Harmonizor.Model.CreateUser;
import com.passionproject.Harmonizor.Model.User;
import com.passionproject.Harmonizor.Service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin
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
            System.out.println(user.getCity());
            return new ResponseEntity<CreateUser>(userService.create(user), HttpStatus.CREATED);
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
}
