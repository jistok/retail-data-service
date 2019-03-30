package io.pivotal.retail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"io.pivotal.retail.dao", "io.pivotal.retail.web"})
public class RetailDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(RetailDataApplication.class, args);
    }
}
