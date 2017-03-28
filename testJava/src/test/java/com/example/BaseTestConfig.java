package com.example;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.*;

@Configuration
@ComponentScan("com.example")
@EnableWebMvc
public class BaseTestConfig {

	@Bean
	public UrlBasedViewResolver setupViewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();

		resolver.setViewClass(JstlView.class);
		return resolver;
	}

}
