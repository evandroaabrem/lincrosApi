package com.lincros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class LincrosApplication  extends SpringBootServletInitializer{

	
	  @Override
	 protected SpringApplicationBuilder configure(
	      SpringApplicationBuilder builder) {
	        return builder.sources(LincrosApplication.class);
	 }
	  
	public static void main(String[] args) {
		SpringApplication.run(LincrosApplication.class, args);
	}

}

