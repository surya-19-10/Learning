package com.security.contoller;

import com.security.security.core.User;
import com.security.security.repo.MyUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private MyUserRepo userRepo;
    @Autowired
    private AuthenticationManager authenticationManager;
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        user.setDPass(user.getPassword());
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepo.save(user);
    }
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if(authentication.isAuthenticated()) {
            return "Success";
        } else {
            return "Login Failed";
        }
    }
}
