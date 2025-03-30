package org.colizeum.crmapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.colizeum.crmapi.dto.GuideDto;
import org.colizeum.crmapi.service.GuideService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/guide")
@Tag(name = "Контроллер гайдов", description = "Управляет созданием, получением и удалением гайдов")
public class GuideController {

    private final GuideService service;

    @Operation(summary = "Создать гайд", description = "Создает новый гайд")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Гайд успешно создан"),
            @ApiResponse(responseCode = "400", description = "Некорректные данные для создания гайда")
    })
    @PostMapping("/create")
    public ResponseEntity<GuideDto> createGuide(@RequestBody GuideDto guideDto) {
        GuideDto createdGuide = service.create(guideDto);
        return ResponseEntity.status(201).body(createdGuide);
    }

    @Operation(summary = "Получить все гайды", description = "Возвращает список всех гайдов")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Список гайдов успешно получен")
    })
    @GetMapping("/guides")
    public ResponseEntity<List<GuideDto>> getAllGuides() {
        List<GuideDto> guides = service.getAllGuides();
        return ResponseEntity.ok(guides);
    }

    @Operation(summary = "Удалить гайд", description = "Удаляет гайд по названию")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Гайд успешно удален"),
            @ApiResponse(responseCode = "404", description = "Гайд не найден")
    })
    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteGuide(@RequestParam String title) {
        service.deleteGuide(title);
        return ResponseEntity.noContent().build();
    }
}
