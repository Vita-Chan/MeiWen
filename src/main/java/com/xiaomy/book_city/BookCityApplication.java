package com.xiaomy.book_city;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableTransactionManagement
@EnableSwagger2
public class BookCityApplication {

  public static void main(String[] args) {
    SpringApplication.run(BookCityApplication.class, args);
  }

}

