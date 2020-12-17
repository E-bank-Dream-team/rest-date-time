package com.example.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.List;

import com.example.controllers.DateTimeController;

import static java.util.Collections.singletonList;

@Configuration
public class SwaggerConfig {

	ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Swagger Application").description("This is Application server.")
				.license("Apache 2.0").licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
				.termsOfServiceUrl("").version("1.0.0").contact(new Contact("", "", "firstname.lastname@capgemini.com"))
				.build();
	}

	@Bean
	public Docket customImplementation() {
		String controllersPackage = DateTimeController.class.getPackageName();
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage(controllersPackage))
				.build()
				.directModelSubstitute(org.threeten.bp.LocalDate.class, java.sql.Date.class)
				.directModelSubstitute(org.threeten.bp.OffsetDateTime.class, java.util.Date.class)
				.apiInfo(apiInfo())
				.securityContexts(singletonList(securityContext()))
				.securitySchemes(singletonList(apiKey()));
	}

	private SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(defaultAuth()).build();
	}

	private List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		return singletonList(new SecurityReference("JWT", authorizationScopes));
	}

	private ApiKey apiKey() {
		return new ApiKey("JWT", "Authorization", "header");
	}

}
