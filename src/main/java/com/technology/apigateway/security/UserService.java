package com.technology.apigateway.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.technology.apigateway.database.entity.User;
import com.technology.apigateway.database.repository.TokenRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class UserService implements UserDetailsService {

    @Autowired
    TokenRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);

        if (user != null)
            return new CustomUserDetails(user);
        else
            throw new UsernameNotFoundException(username);
    }

}
