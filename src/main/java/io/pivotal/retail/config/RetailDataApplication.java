package io.pivotal.retail.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = "io.pivotal.retail")
@ComponentScan({"io.pivotal.retail.dao"})
public class RetailDataApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(RetailDataApplication.class);
	}

	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(RetailDataApplication.class);
		ApplicationContext context = SpringApplication.run(RetailDataApplication.class, args);
	}
}
