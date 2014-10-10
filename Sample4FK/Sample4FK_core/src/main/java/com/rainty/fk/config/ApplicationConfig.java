package com.rainty.fk.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@EnableJpaRepositories(basePackages="com.rainty.fk.repository")
@Import(H2DatabaseConfig.class)
public class ApplicationConfig {

	
	
}
