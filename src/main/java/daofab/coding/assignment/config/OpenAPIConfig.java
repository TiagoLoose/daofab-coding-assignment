package daofab.coding.assignment.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI eCertOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("DAOFAV")
                        .description("Coding Assignment")
                        .version("v1.0.0"))
                ;
    }
}
