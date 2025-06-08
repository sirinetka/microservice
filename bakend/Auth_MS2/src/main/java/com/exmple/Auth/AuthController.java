package com.exmple.Auth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
public class AuthController {

  @Autowired
  private UserRepository repo;

  @Autowired
  private PasswordEncoder encoder;

  @Autowired
  private JwtUtil jwt;

  @PostMapping("/register")
  public String register(@RequestBody User u) {
    u.password = encoder.encode(u.password);
    repo.save(u);
    return "OK";
  }

  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody User u) {
    return repo.findByUsername(u.username)
      .filter(user -> encoder.matches(u.password, user.password))
      .map(user -> ResponseEntity.ok(Map.of("token", jwt.generateToken(user.username),"role", user.role ,"id", user.id  )))
      .orElseGet(() -> ResponseEntity.status(401).body(Map.of("error", "Bad credentials")));
  };
}
