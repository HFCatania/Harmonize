package com.passionproject.Harmonizor.Service;

import com.passionproject.Harmonizor.Model.CreateUser;
import com.passionproject.Harmonizor.Model.User;
import com.passionproject.Harmonizor.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User create(CreateUser user){
        System.out.println(user.getCity());
        User endUser= new User();
        endUser.setEmail(user.getEmail());
        endUser.setPassword(user.getPassword());
        endUser.setFirstName(user.getFirstName());
        endUser.setLastName(user.getLastName());
        endUser.setCity(user.getCity());
        endUser.setState(user.getState());
        endUser.setCountry(user.getCountry());
        return userRepository.save(endUser); }

    public Iterable<User> findAll(){ return userRepository.findAll();}

//    public User show(Long id) { return userRepository.findById(id); }
}
