package com.chamrong.springbootexitcodegenerator;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeEvent;
import org.springframework.boot.ExitCodeExceptionMapper;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SpringBootExitCodeGeneratorApplication implements ExitCodeGenerator {

  public static void main(String[] args) {
    System.exit(SpringApplication.exit(
        SpringApplication.run(SpringBootExitCodeGeneratorApplication.class, args)
    ));
  }

  @Override
  public int getExitCode() {
    return 33;
  }

  @Bean
  ExitCodeExceptionMapper exitCodeToexceptionMapper() {
    return exception -> {

      if (exception.getCause() instanceof NumberFormatException) {
        return 34;
      }
      if (exception.getCause() instanceof NullPointerException) {
        return 45;
      }
      return 1;
    };
  }

  @Bean
  CommandLineRunner createException() {
    return args -> Integer.parseInt("test");
  }

  @Bean
  SampleEventListener sampleEventListener() {
    return new SampleEventListener();
  }

  private static class SampleEventListener {

    @EventListener
    public void exitEvent(ExitCodeEvent event) {
      System.out.println("Application Exit code: " + event.getExitCode());
    }
  }
}
