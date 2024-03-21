package com.mx.serti.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public GroupedOpenApi publicApi() {
        String[] paths = {
                "/requests/**"
        };
        return GroupedOpenApi.builder().group("serti").pathsToMatch(paths).build();
    }

}