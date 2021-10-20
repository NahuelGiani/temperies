package com.temperies.movie.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperInit {
	
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
	
}
