package com.passionproject.Harmonizor.Service;

import com.passionproject.Harmonizor.Model.User;
import com.passionproject.Harmonizor.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User create(User user){ return (User) userRepository.save(user); }

    public Iterable<User> findAll(){ return userRepository.findAll();}

//    public User show(Long id) { return userRepository.findById(id); }
}
