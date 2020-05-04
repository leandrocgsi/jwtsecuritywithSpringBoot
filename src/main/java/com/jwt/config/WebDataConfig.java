package com.jwt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebDataConfig implements WebMvcConfigurer{

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		//http://localhost:8080/person/1.xml
//		configurer.favorParameter(false)
//		.ignoreAcceptHeader(false)
//		.defaultContentType(MediaType.APPLICATION_JSON)
//		.mediaType("json", MediaType.APPLICATION_JSON)
//		.mediaType("xml", MediaType.APPLICATION_XML);
		
		configurer.favorPathExtension(false)
		.favorParameter(true)
		.ignoreAcceptHeader(false)
		.parameterName("mediatype")
		.useRegisteredExtensionsOnly(false)
		.defaultContentType(MediaType.APPLICATION_JSON)
		.mediaType("json", MediaType.APPLICATION_JSON)
		.mediaType("xml", MediaType.APPLICATION_XML);
	}

	
}
