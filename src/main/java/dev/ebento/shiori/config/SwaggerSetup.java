package dev.ebento.shiori.config;

import java.time.LocalDate;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SwaggerSetup {

	@Autowired
	private BuildProperties buildProperties;
	
	@Bean
	public Docket shioriApi() {

		final ApiInfo apiInfo = new ApiInfo(
				buildProperties.getName(), 
				buildProperties.get("project.description"),
		        buildProperties.getVersion(), 
		        "urn:tos", 
		        new Contact("team", "ebento.dev", "admin@ebento.dev"), 
		        "Apache 2.0", 
		        "http://www.apache.org/licenses/LICENSE-2.0", Collections.emptyList());

		return new Docket(DocumentationType.SWAGGER_2) //
				.select().apis(RequestHandlerSelectors.basePackage("dev.ebento.shiori")) //
				.paths(PathSelectors.any()).build() //
				.pathMapping("/") //
				.apiInfo(apiInfo) //
				.directModelSubstitute(LocalDate.class, String.class);
	}

}
