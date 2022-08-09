package com.example.bushub.management;

import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

  @GetMapping
  public String hello(JwtAuthenticationToken jwtAuthenticationToken) {
    return String.format("Hello %s!", jwtAuthenticationToken.getName());
  }
}
