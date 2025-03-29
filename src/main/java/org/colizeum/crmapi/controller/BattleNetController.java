package org.colizeum.crmapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.colizeum.crmapi.dto.BattleNetDto;
import org.colizeum.crmapi.service.BattleNetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/battlenet")
@Tag(name = "Контроллер игр Battle.net", description = "Управляет созданием и удалением списка игр Battle.net")
public class BattleNetController {

    private final BattleNetService service;

    @Operation(summary = "Добавить игру в исключения", description = "Добавляет новую игру Battle.net в исключения на удаление")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Игра успешно добавлена"),
            @ApiResponse(responseCode = "400", description = "Некорректные данные для добавления игры")
    })
    @PostMapping("/create")
    public ResponseEntity<BattleNetDto> createGame(@RequestBody BattleNetDto battleNetDto) {
        BattleNetDto createdGame = service.create(battleNetDto);
        return ResponseEntity.status(201).body(createdGame);
    }

    @Operation(summary = "Получить все игры", description = "Возвращает список всех игр в списке исключений на удаление Battle.net")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Список игр успешно получен")
    })
    @GetMapping("/games")
    public ResponseEntity<List<BattleNetDto>> getAllGames() {
        List<BattleNetDto> games = service.getAllGames();
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