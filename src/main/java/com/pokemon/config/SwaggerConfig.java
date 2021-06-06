package com.pokemon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {
	@Bean
	 public OpenAPI filmesOpenAPI() {
	 return new OpenAPI().info(new Info()
	 .title("Pokemon API")
	 .description("Api desenvolvida para avaliação do 2º semestre da matéria Desenvolvimento para Servidores II")
	 .version("v0.0.1")
	 .contact(new Contact()
	 .name("Manoel Vitor da Silva").email("manoelvitor4g2@gmail.com"))
	 .license(new License()
	 .name("Apache 2.0").url("http://springdoc.org")));
	 }
}
