package br.com.iago.restap.serialization;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

public class YamlJackson2HttpMeSageConverter extends AbstractJackson2HttpMessageConverter {

	public YamlJackson2HttpMeSageConverter() {
		super(new YAMLMapper()
				.setSerializationInclusion(JsonInclude.Include.NON_NULL), 
				MediaType.parseMediaType("applicatoon/x-yaml"));
		
	}




}
