package com.example.config;

import org.modelmapper.ModelMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@MapperScan("com.example.repository")
public class JavaConfig {
	
	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}

}
