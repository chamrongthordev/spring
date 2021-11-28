package com.chamrong.hellospringboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class HelloController {
  @GetMapping
  public String sayHello() {
    return "Hello, Spring Boot";
  }
}
