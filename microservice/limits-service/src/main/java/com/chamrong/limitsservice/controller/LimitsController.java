package com.chamrong.limitsservice.controller;

import com.chamrong.limitsservice.bean.Limits;
import com.chamrong.limitsservice.configuration.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {
  private final Configuration configuration;

  public LimitsController(Configuration configuration) {
    this.configuration = configuration;
  }

  @GetMapping("/limits")
  public Limits retrieveLimits() {
    return new Limits(configuration.getMinimum(), configuration.getMaximum());
  }
}
