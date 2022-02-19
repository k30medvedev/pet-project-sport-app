package by.kirill.sportsman.app.config.swagger;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {
    @Value("${app.api.version}")
    private String version;

    @Value("${app.api.title}")
    private String title;

    @Value("${app.api.description}")
    private String description;

    @Value("${app.api.contact-name}")
    private String contactName;

    @Value("${app.api.contact-email}")
    private String contactEmail;

    @Bean
    public GroupedOpenApi publicUserApi() {
        return GroupedOpenApi.builder()
                .group("Users")
                .pathsToMatch("/users/**")
                .build();
    }

    @Bean
    public OpenAPI springOpenAPI() {
        return new OpenAPI().info(new Info().title(title)
                .description(description)
                .version(version)
                .license(new License().name("Apache 2.0")
                        .url("http://springdoc.org"))
                .contact(new Contact().name(contactName)
                        .email(contactEmail)));
    }

}
