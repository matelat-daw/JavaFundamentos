package com.miapp.holamundo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Holamundo2Application.class);
	}
	public static void main(String[] args) {
        SpringApplication.run(Holamundo2Application.class, args);
    }
}