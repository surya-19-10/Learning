package com.security.security.service;

import com.security.security.core.User;
import com.security.security.core.UserPrincipal;
import com.security.security.repo.MyUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private MyUserRepo myUserRepo;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = myUserRepo.findByUsername(s);
        if(user==null) throw new UsernameNotFoundException("User not Found");
        return new UserPrincipal(user);
    }
}
