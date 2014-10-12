package com.rainty.fk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;


@Configuration
@EnableJpaRepositories(basePackages="com.rainty.fk.repository")
@ComponentScan(basePackages="com.rainty.fk.service")
@Import(H2DatabaseConfig.class)
public class ApplicationConfig {
	
}
