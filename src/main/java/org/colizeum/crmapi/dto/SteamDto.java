package org.colizeum.crmapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Сущность Steam")
public class SteamDto {

    @Schema(description = "Название папки игры Steam, может быть пустым")
    private String name;

    @Schema(description = "Уникальный идентификатор игры Steam")
    @NotBlank
    private String manifestId;

}
