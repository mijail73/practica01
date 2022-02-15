package mx.unam.mijail.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConf {
  public static final Contact DEFAULT_CONTACT =
      new Contact("Mijail Alvarez", "https://github.com/mijail73", "mijail.iso@ciencias.unam.mx");

  @SuppressWarnings("rawtypes")
  public static final ApiInfo DEFAULT_API_INFO =
      new ApiInfo(
          "Practica01",
          "Solucion P1 y P2",
          "1.0",
          "urn:tos",
          DEFAULT_CONTACT,
          "licencia libre",
          "https://www.google.com/",
          new ArrayList<>());

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .useDefaultResponseMessages(false)
        .apiInfo(DEFAULT_API_INFO)
        .select()
        .apis(RequestHandlerSelectors.basePackage("mx.unam.mijail.controller"))
        .build();
  }
}
