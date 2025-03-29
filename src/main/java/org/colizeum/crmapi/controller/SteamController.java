package org.colizeum.crmapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.colizeum.crmapi.dto.SteamDto;
import org.colizeum.crmapi.service.SteamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/steam")
@Tag(name = "Контроллер игр Steam", description = "Управляет созданием и удалением списка игр Steam")
public class SteamController {

    private final SteamService service;

    @Operation(summary = "Добавить игру в исключения", description = "Добавляет новую игру Steam в исключения на удаление")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Игра успешно добавлена"),
            @ApiResponse(responseCode = "400", description = "Некорректные данные для добавления игры")
    })
    @PostMapping("/create")
    public ResponseEntity<SteamDto> createGame(@RequestBody SteamDto steamDto) {
        SteamDto createdGame = service.create(steamDto);
        return ResponseEntity.status(201).body(createdGame);
    }

    @Operation(summary = "Получить все игры", description = "Возвращает список всех игр в списке исключений на удаление Steam")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Список игр успешно получен")
    })
    @GetMapping("/games")
    public ResponseEntity<List<SteamDto>> getAllGames() {
        List<SteamDto> games = service.getAllGames();
        return ResponseEntity.ok(games);
    }

    @Operation(summary = "Удалить игру", description = "Удаляет игру по имени из списка исключений на удаление")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Игра успешно удалена"),
            @ApiResponse(responseCode = "404", description = "Игра не найдена")
    })
    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteGame(@RequestParam String name) {
        service.deleteGame(name);
        return ResponseEntity.noContent().build();
    }
}
