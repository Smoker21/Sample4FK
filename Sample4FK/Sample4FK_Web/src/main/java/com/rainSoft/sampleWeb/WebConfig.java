package com.rainSoft.sampleWeb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.rainty.fk.config.ApplicationConfig;

@Configuration
@ComponentScan(basePackages = { "com.rainSoft.sampleWeb" })
@EnableWebMvc
@Import(ApplicationConfig.class)
/**
 * The class is to replace the default WEB-INF/dispatcher.xml
 * @author Lance
 *
 */
public class WebConfig extends WebMvcConfigurerAdapter {

	@Bean
	/**
	 * Get the view Resolver.
	 * @return
	 */
	public ViewResolver viewResolver() {
		final InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		//		resolver.setSuffix(".jsp");
		return resolver;
	}

	//	@Bean(name = "multipartResolver")
	//	public CommonsMultipartResolver getMultipartResolver() {
	//		return new CommonsMultipartResolver();
	//	}

	/**
	 * For i18n message settings
	 * 
	 * @return
	 */
	@Bean(name = "messageSource")
	public ReloadableResourceBundleMessageSource getMessageSource() {
		final ReloadableResourceBundleMessageSource resource = new ReloadableResourceBundleMessageSource();
		resource.setBasename("classpath:messages");
		resource.setDefaultEncoding("UTF-8");
		return resource;
	}

	@Override
	public void configureDefaultServletHandling(final DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

}
