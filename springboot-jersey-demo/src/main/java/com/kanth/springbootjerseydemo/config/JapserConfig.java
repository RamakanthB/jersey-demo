package com.kanth.springbootjerseydemo.config;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.kanth.springbootjerseydemo.controllers.EmployeeController;

@Configuration
@ApplicationPath("rest")
public class JapserConfig extends ResourceConfig {

	@PostConstruct
	public void serviceSetup() {
		register(EmployeeController.class);
	}

}
