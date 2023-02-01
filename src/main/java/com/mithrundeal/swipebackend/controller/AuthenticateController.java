package com.mithrundeal.swipebackend.controller;

import com.mithrundeal.swipebackend.dto.SwipeUser;
import com.mithrundeal.swipebackend.dto.response.JwtResponse;
import com.mithrundeal.swipebackend.jwt.JwtTokenUtil;
import com.mithrundeal.swipebackend.repository.UserRepository;
import com.mithrundeal.swipebackend.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AuthenticateController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody SwipeUser swipeUser) {

        try {
            authenticate(swipeUser.getUserName(), swipeUser.getPassword());
            final UserDetails userDetails = userDetailsService.loadUserByUsername(swipeUser.getUserName());
            final String token = jwtTokenUtil.generateToken(userDetails);
            return ResponseEntity.ok(new JwtResponse(token));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
