package org.colizeum.crmapi.service;

import lombok.RequiredArgsConstructor;
import org.colizeum.crmapi.dto.SteamDto;
import org.colizeum.crmapi.exception.GameNotFoundException;
import org.colizeum.crmapi.model.Steam;
import org.colizeum.crmapi.repository.SteamRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SteamService {

    private final SteamRepository repository;
    private final ModelMapper modelMapper;

    @Transactional
    public SteamDto create(SteamDto dto) {
        Steam game = modelMapper.map(dto, Steam.class);
        Steam savedGame = repository.save(game);
        return modelMapper.map(savedGame, SteamDto.class);
    }

    public List<SteamDto> getAllGames() {
        return repository.findAll().stream().map(this::mapToSteamDto).collect(Collectors.toList());
    }

    @Transactional
    public void deleteGame(String name) {
        if (repository.findByName(name).isEmpty()) {
            throw new GameNotFoundException("Game with name " + name + " not found");
        }
        repository.deleteByName(name);
    }


    private SteamDto mapToSteamDto(Steam steam) {
        return modelMapper.map(steam, SteamDto.class);
    }
}
