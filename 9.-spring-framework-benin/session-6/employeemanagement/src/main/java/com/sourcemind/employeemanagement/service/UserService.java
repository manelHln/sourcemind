package com.sourcemind.employeemanagement.service;


import com.sourcemind.employeemanagement.entity.Utilisateur;
import com.sourcemind.employeemanagement.exception.RessourceAlreadyExistException;
import com.sourcemind.employeemanagement.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    public Utilisateur register(Utilisateur user, HttpServletRequest request) {
        // check if user already existed
        if (userRepository.findByUsername(user.getEmail()).isPresent()) {
            throw new RessourceAlreadyExistException(String.format("The email address %s already exists", user.getEmail()));
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public List<Utilisateur> allUsers() {
        return userRepository.findAll();
    }


    public Utilisateur enableDisable(String userId, boolean value) {
        Utilisateur user = userRepository.findById(Integer.valueOf(userId)).get();
        user.setEnabled(value);

        userRepository.save(user);

        return user;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(String.format("User: %s, not found", username)));
    }


}
