package org.colizeum.crmapi.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Colizeum CRM API",
                description = "Сервис для работы клуба Colizeum",
                version = "1.0.0",
                contact = @Contact(
                        name = "Pipia Zaza",
                        email = "zaza.pipia.023@yandex.ru"
                )
        )
)
public class OpenApiConfig {
}
