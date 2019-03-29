package com.kanth.springbootjerseydemo.config;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.context.annotation.Configuration;

import com.kanth.springbootjerseydemo.controllers.EmployeeController;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;

@Configuration
@ApplicationPath("rest")
public class JapserConfig extends ResourceConfig {

	@PostConstruct
	public void serviceSetup() {
		register(EmployeeController.class);
		swaggerConfig();
		property(ServletProperties.FILTER_FORWARD_ON_404, true);
	}

	private void swaggerConfig() {

		this.register(ApiListingResource.class);
		this.register(SwaggerSerializers.class);

		BeanConfig swaggerConfigBean = new BeanConfig();
		swaggerConfigBean.setConfigId("springboot-jersey-demo");
		swaggerConfigBean.setTitle("Using Swagger ,Jersey And Spring Boot ");
		swaggerConfigBean.setVersion("v1");
		swaggerConfigBean.setContact("Ramakanth");
		swaggerConfigBean.setSchemes(new String[] { "http", "https" });
		swaggerConfigBean.setBasePath("/swagger");
		swaggerConfigBean.setResourcePackage("com.kanth.springbootjerseydemo");
		swaggerConfigBean.setPrettyPrint(true);
		swaggerConfigBean.setScan(true);
	}

}
