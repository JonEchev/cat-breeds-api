package breed.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Breeds Cat API")
                        .version("1.0")
                        .description("Documentación de la API que permite la consulta a servicio externo de razas de gatos para Xpert Group.")
                        .contact(new Contact()
                                .name("Jonatan Echeverry")
                                .email("jonechev1@gmail.com")
                                .url("https://github.com/JonEchev/cat-breeds-api")
                        )
                );
    }

}