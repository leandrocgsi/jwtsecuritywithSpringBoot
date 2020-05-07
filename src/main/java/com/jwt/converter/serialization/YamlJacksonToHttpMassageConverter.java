package com.jwt.converter.serialization;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

public final class YamlJacksonToHttpMassageConverter extends AbstractJackson2HttpMessageConverter {

	public YamlJacksonToHttpMassageConverter() {
		super(new YAMLMapper(), MediaType.parseMediaType("application/x-yaml"));
		// TODO Auto-generated constructor stub
		//if needed for removing null value
		// super(new YAMLMapper().setSerializationInclusion(Include.NON_NULL),
		// MediaType.parseMediaType("application/x-yaml"));
	}

}
