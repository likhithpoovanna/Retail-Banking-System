package com.cognizant.RetailBanking.Customers;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableFeignClients
@EnableSwagger2
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	
	/**
	 * @SWAGGER BEAN
	 * @return
	 */
	@Bean
	public Docket swaggerConfiguration() {

		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.cognizant.RetailBanking.Customers.Controller")).build().apiInfo(apiInfo());

	}  

	/**
	 * @SWAGGER CONFIGURATION
	 * @return
	 */

	private ApiInfo apiInfo() {
		return new ApiInfo("Customer Service", "MFPE project service", "API", "Terms of service",
				new Contact("Pawan","", "ghogarepawan98@gmail.com"), "License of API", "",Collections.emptyList());
	}

}
  