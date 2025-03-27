package org.colizeum.crmapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Сущность Battle Net")
public class BattleNetDto {

    @Schema(description = "Название папки игры Battle Net")
    @NotBlank
    private String name;

}
