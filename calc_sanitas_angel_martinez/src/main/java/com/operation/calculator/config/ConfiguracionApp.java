package com.operation.calculator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.operation.calculator.services.OperationsCalculatorService;
import com.operation.calculator.services.impl.OperationsCalculatorServiceImpl;
 
@Configuration
@EnableScheduling
public class ConfiguracionApp implements WebMvcConfigurer {
 
@Bean
 public OperationsCalculatorService operationsCalculatorService() 
 {
	return new OperationsCalculatorServiceImpl();
 }

}