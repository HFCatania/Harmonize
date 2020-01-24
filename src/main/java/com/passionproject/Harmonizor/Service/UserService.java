package com.passionproject.Harmonizor.Service;

import com.passionproject.Harmonizor.Model.CreateUser;
import com.passionproject.Harmonizor.Model.Profile;
import com.passionproject.Harmonizor.Model.User;
import com.passionproject.Harmonizor.Repository.UserRepository;
import com.passionproject.Harmonizor.Security.CustomException;
import com.passionproject.Harmonizor.Security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;


@Service
public class UserService {

    private UserRepository userRepository;
    private AuthenticationManager authenticationManager;
    private JwtTokenProvider jwtTokenProvider;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.passwordEncoder = passwordEncoder;
    }

    public User convertUser(CreateUser user){
//        System.out.println(user.getCity());
        User endUser = new User();
        endUser.setEmail(user.getEmail());
        endUser.setPassword(user.getPassword());
        endUser.setFirstName(user.getFirstName());
        endUser.setLastName(user.getLastName());
//        endUser.setCity(user.getCity());
//        endUser.setState(user.getState());
//        endUser.setCountry(user.getCountry());
        return endUser;
    }

    public User create(CreateUser user) {
        User endUser = convertUser(user);
        return userRepository.save(endUser);
    }
//
//    public String registerUser(User user){
//
//        User endUser = convertUser(user);
//        if (!userRepository.existsByEmail(user.getEmail())) {
//            user.setPassword(passwordEncoder.encode(user.getPassword()));
//            userRepository.save(user);
//            return jwtTokenProvider.createToken(user.getEmail());
//        } else {
//            throw new CustomException("That email address is already linked to an account.", HttpStatus.UNPROCESSABLE_ENTITY);
//        }
//    }

    public User registerUser(User user) {
        if (!userRepository.existsByEmail(user.getEmail())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            Profile profile = new Profile(user.getId());
            user.setProfile(profile);
            user.setToken(jwtTokenProvider.createToken(user.getEmail()));
            return userRepository.save(user);
        } else {
            throw new CustomException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public Iterable<User> findAll(){ return userRepository.findAll();}

    public User logIn(User user) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
            user = userRepository.findByEmail(user.getEmail());
            user.setToken(jwtTokenProvider.createToken(user.getEmail()));
            return user;
        } catch (AuthenticationException e) {
            System.out.println(e.getMessage());
            throw new CustomException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }


//    public String logIn(String email, String password){
//        try {
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
//            return jwtTokenProvider.createToken(email);
//        } catch (AuthenticationException e){
//            System.out.println(e.getMessage());
//            throw new CustomException("Invalid email/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
//        }
//    }

    public User whoami(HttpServletRequest req){
        return userRepository.findByEmail(jwtTokenProvider.getEmail(jwtTokenProvider.resolveToken(req)));
    }

//    public User show(Long id) { return userRepository.findById(id); }
}
