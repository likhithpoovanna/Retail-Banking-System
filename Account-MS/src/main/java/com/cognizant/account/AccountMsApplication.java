package com.cognizant.account;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*
 * The main class of the Account-MS which loads all the components and starts the account microservice.
 */

@SpringBootApplication
@EnableFeignClients
@EnableSwagger2
public class AccountMsApplication {

	/* The main method of the application. */
	public static void main(String[] args) {
		SpringApplication.run(AccountMsApplication.class, args);
	}

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.cognizant.account.controller")).build()
				.apiInfo(apiInfo());

	}  

	/* API Info for Swagger Dashboard. */
	private ApiInfo apiInfo() {
		return new ApiInfo("Account Service.", "MFPE Retail Banking System.", "API", "Terms of service",
				new Contact("Likhith Poovanna. I. B.", "", "896841@cognizant.com"), "License of API", "",
				Collections.emptyList());
	}

}
