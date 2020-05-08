package com.jwt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebDataConfig implements WebMvcConfigurer{
	
	public void addCorsMapping(CorsRegistry registry) {
		registry.addMapping("/**")
		.allowedMethods("GET", "PUT", "DELETE" , "POST" , "PATCH", 
				"OPTIONS", "TRACE", "CONNECT");
	}

}
