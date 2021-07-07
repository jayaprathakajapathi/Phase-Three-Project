package com.Sportyshoes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
// @Configuration - Marks class as source of bean definition
// @EnableAutoConfiguration - Add dependency automatically
// @ComponentScan	- Scans for Configurations for as same package or below
// @SpringBootApplication = @Configuration + @EnableAutoConfiguration + @ComponentScan
public class App {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(App.class, args);
		
		Thread.sleep(1000l);
			
		

	}

}