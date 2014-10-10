package com.rainty.fk.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@EnableJpaRepositories
@Import(H2DatabaseConfig.class)
public class ApplicationConfig {

	
	
}
