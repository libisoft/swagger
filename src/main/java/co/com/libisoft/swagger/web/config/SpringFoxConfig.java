package co.com.libisoft.swagger.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
public class SpringFoxConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getInfo())
                .securityContexts(Arrays.asList(securityContext()))
                .securitySchemes(Arrays.asList(apiKey()))
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo getInfo(){
        return new ApiInfo(
                "Demo Spring boot, swagger y JWT",
                "Aplicación basica de compras",
                "2.0",
                "Terminos y condiciones",
                new Contact("Libisoft","www.libisoft.com","gerencia@libisoft.com"),
                "Licencia",
                "www.licencia.com",
                Collections.emptyList()
        );
    }

    private ApiKey apiKey(){
        return new ApiKey("JWT","Authorization","header");
    }

    private SecurityContext securityContext(){

        return SecurityContext.builder().securityReferences(defaultAthentication()).build();
    }

    private List<SecurityReference> defaultAthentication(){
        AuthorizationScope authorizationScope=new AuthorizationScope("global","accessEverything");
        AuthorizationScope[] authorizationScopes=new AuthorizationScope[1];
        authorizationScopes[0]=authorizationScope;
        return Arrays.asList(new SecurityReference("JWT",authorizationScopes));
    }

}
