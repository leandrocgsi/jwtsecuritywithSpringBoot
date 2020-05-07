package com.jwt.converter.serialization;

import java.io.IOException;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.yaml.snakeyaml.Yaml;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

public final class YamlJacksonToHttpMassageConverter extends AbstractJackson2HttpMessageConverter {

	public YamlJacksonToHttpMassageConverter() {
		super(new YAMLMapper(), MediaType.parseMediaType("application/x-yaml"));
		// TODO Auto-generated constructor stub
	}


}
