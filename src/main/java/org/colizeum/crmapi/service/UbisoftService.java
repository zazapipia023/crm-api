package org.colizeum.crmapi.service;

import lombok.RequiredArgsConstructor;
import org.colizeum.crmapi.dto.UbisoftDto;
import org.colizeum.crmapi.exception.GameNotFoundException;
import org.colizeum.crmapi.model.Ubisoft;
import org.colizeum.crmapi.repository.UbisoftRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UbisoftService {

    private final UbisoftRepository repository;
    private final ModelMapper modelMapper;

    @Transactional
    public UbisoftDto create(UbisoftDto dto) {
        Ubisoft game = modelMapper.map(dto, Ubisoft.class);
        Ubisoft savedGame = repository.save(game);
        return modelMapper.map(savedGame, UbisoftDto.class);
    }

    public List<UbisoftDto> getAllGames() {
        return repository.findAll().stream().map(this::mapToUbisoftDto).collect(Collectors.toList());
    }

    @Transactional
    public void deleteGame(String name) {
        if (repository.findByName(name).isEmpty()) {
            throw new GameNotFoundException("Game with name " + name + " not found");
        }
        repository.deleteByName(name);
    }

    private UbisoftDto mapToUbisoftDto(Ubisoft game) {
        return modelMapper.map(game, UbisoftDto.class);
    }
}
