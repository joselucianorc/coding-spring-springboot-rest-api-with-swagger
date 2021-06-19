package br.com.joselucianorc.schoolapi.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("test-api")
				.apiInfo(apiInfo())
				.select()
				.paths(postPaths())
				.build();
	}

	private Predicate<String> postPaths() {
		return regex("/v1/schools.*");
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("School API")
				.description("School API used to implement a simple rest api")						
				.licenseUrl("joselucianorc@mail.com")
				.version("1.0")
				.build();
	}

}