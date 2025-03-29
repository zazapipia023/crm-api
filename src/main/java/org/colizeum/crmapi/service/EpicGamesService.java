package org.colizeum.crmapi.service;

import lombok.RequiredArgsConstructor;
import org.colizeum.crmapi.dto.EpicGamesDto;
import org.colizeum.crmapi.exception.GameNotFoundException;
import org.colizeum.crmapi.model.EpicGames;
import org.colizeum.crmapi.repository.EpicGamesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EpicGamesService {

    private final EpicGamesRepository repository;
    private final ModelMapper modelMapper;

    @Transactional
    public EpicGamesDto create(EpicGamesDto dto) {
        EpicGames game = modelMapper.map(dto, EpicGames.class);
        EpicGames savedGame = repository.save(game);
        return modelMapper.map(savedGame, EpicGamesDto.class);
    }

    public List<EpicGamesDto> getAllGames() {
        return repository.findAll().stream().map(this::mapToEpicGamesDto).collect(Collectors.toList());
    }

    @Transactional
    public void deleteGame(String name) {
        if (repository.findByName(name).isEmpty()) {
            throw new GameNotFoundException("Game with name " + name + " not found");
        }
        repository.deleteByName(name);
    }

    private EpicGamesDto mapToEpicGamesDto(EpicGames game) {
        return modelMapper.map(game, EpicGamesDto.class);
    }



}
