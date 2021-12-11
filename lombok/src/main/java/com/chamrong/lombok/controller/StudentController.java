package com.chamrong.lombok.controller;

import com.chamrong.lombok.utils.CustomClass;
import com.chamrong.lombok.utils.CustomUtility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class StudentController {
  @GetMapping("/hello")
  public String home() {
    log.info("Info logger");

    CustomClass customClass = CustomClass.builder().build();

    String s = CustomUtility.toUpperCase("DCB");
    return "Welcome to my HOME";
  }
}
