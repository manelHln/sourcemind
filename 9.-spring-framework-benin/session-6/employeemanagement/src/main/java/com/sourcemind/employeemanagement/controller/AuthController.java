package com.sourcemind.employeemanagement.controller;

import com.sourcemind.employeemanagement.dto.AuthRequest;
import com.sourcemind.employeemanagement.entity.Utilisateur;
import com.sourcemind.employeemanagement.service.UserService;
import com.sourcemind.employeemanagement.util.JwtTokenUtil;
import com.sourcemind.employeemanagement.validator.RetrieveValidationError;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserService userService;

    @Autowired
    private RetrieveValidationError retrieveValidationError;

    @PostMapping("register")
    public ResponseEntity<?> register(@RequestBody @Valid Utilisateur user, HttpServletRequest request, BindingResult result) {

        // gestion de la validation
        if (result.hasErrors()) {
            return retrieveValidationError.retrieveErrors(result);
        }


        return new ResponseEntity<>(userService.register(user, request), HttpStatus.CREATED);
    }

    @PostMapping("login")
    public ResponseEntity<Utilisateur> login(@RequestBody  AuthRequest request) {
        try {
            Authentication authenticate = authenticationManager
                    .authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    request.getUsername(), request.getPassword()
                            )
                    );


            Utilisateur user = (Utilisateur) authenticate.getPrincipal();

            return ResponseEntity.ok()
                    .header(
                            HttpHeaders.AUTHORIZATION,
                            jwtTokenUtil.generateAccessToken(user)
                    )
                    .body(user);
        } catch (BadCredentialsException | ClassCastException ex) {
            SecurityContextHolder.getContext().setAuthentication(null);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
