package org.colizeum.crmapi.service;

import lombok.RequiredArgsConstructor;
import org.colizeum.crmapi.dto.BattleNetDto;
import org.colizeum.crmapi.exception.GameNotFoundException;
import org.colizeum.crmapi.model.BattleNet;
import org.colizeum.crmapi.repository.BattleNetRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BattleNetService {

    private final BattleNetRepository repository;
    private final ModelMapper modelMapper;

    @Transactional
    public BattleNetDto create(BattleNetDto dto) {
        BattleNet game = modelMapper.map(dto, BattleNet.class);
        BattleNet savedGame = repository.save(game);
        return modelMapper.map(savedGame, BattleNetDto.class);
    }

    public List<BattleNetDto> getAllGames() {
        return repository.findAll().stream().map(this::mapToBattleNetDto).collect(Collectors.toList());
    }

    @Transactional
    public void deleteGame(String name) {
        if (repository.findByName(name).isEmpty()) {
            throw new GameNotFoundException("Game with name " + name + " not found");
        }
        repository.deleteByName(name);
    }

    private BattleNetDto mapToBattleNetDto(BattleNet game) {
        return modelMapper.map(game, BattleNetDto.class);
    }
}
