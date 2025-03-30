package org.colizeum.crmapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Сущность Guide")
public class GuideDto {

    @Schema(description = "Название статьи/гайда")
    @NotBlank
    private String title;

    @Schema(description = "Ссылка на статью")
    @NotBlank
    private String link;

}
