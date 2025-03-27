package org.colizeum.crmapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Сущность VK Play")
public class VkPlayDto {

    @Schema(description = "Название папки игры VK Play")
    @NotBlank
    private String name;

}
