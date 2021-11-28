package com.chamrong.restapp.ticketmanagement.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class HelloController {
  @GetMapping
  public String sayLam() {
    return "Lam";
  }
}
