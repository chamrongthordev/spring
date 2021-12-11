package com.chamrong.springsecurityjwt.controller;

import com.chamrong.springsecurityjwt.model.JwtRequest;
import com.chamrong.springsecurityjwt.model.JwtResponse;
import com.chamrong.springsecurityjwt.service.UserService;
import com.chamrong.springsecurityjwt.utility.JWTUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

  @Autowired
  private JWTUtility jwtUtility;

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private UserService userService;

  @GetMapping("/")
  public String home() {
    return "Welcome to Chamrong!";
  }

  @PostMapping("/authenticate")
  public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception {
    try {
      authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(
              jwtRequest.getUsername(),
              jwtRequest.getPassword()
          )
      );
    } catch (BadCredentialsException e) {
      throw new Exception("INVALID_CREDENCIALS", e);
    }

    final UserDetails userDetails
        = userService.loadUserByUsername(jwtRequest.getUsername());
    final String token =
        jwtUtility.generateToken(userDetails);

    return new JwtResponse(token);
  }
}
