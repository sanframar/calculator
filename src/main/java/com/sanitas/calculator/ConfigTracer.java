package com.sanitas.calculator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import io.corp.calculator.TracerImpl;

@Configuration
@ComponentScan("com.sanitas.calculator.tracer.TracerImpl")
public class ConfigTracer {
	
	@Bean
	public TracerImpl tracer() {
		return new TracerImpl();
	}

}
