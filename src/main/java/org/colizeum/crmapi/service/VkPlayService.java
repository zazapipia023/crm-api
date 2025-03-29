package org.colizeum.crmapi.service;

import lombok.RequiredArgsConstructor;
import org.colizeum.crmapi.dto.VkPlayDto;
import org.colizeum.crmapi.exception.GameNotFoundException;
import org.colizeum.crmapi.model.VkPlay;
import org.colizeum.crmapi.repository.VkPlayRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class VkPlayService {

    private final VkPlayRepository repository;
    private final ModelMapper modelMapper;

    @Transactional
    public VkPlayDto create(VkPlayDto dto) {
        VkPlay game = modelMapper.map(dto, VkPlay.class);
        VkPlay savedGame = repository.save(game);
        return modelMapper.map(savedGame, VkPlayDto.class);
    }

    public List<VkPlayDto> getAllGames() {
        return repository.findAll().stream().map(this::mapToVkPlayDto).collect(Collectors.toList());
    }

    @Transactional
    public void deleteGame(String name) {
        if (repository.findByName(name).isEmpty()) {
            throw new GameNotFoundException("Game with name " + name + " not found");
        }
        repository.deleteByName(name);
    }

    private VkPlayDto mapToVkPlayDto(VkPlay game) {
        return modelMapper.map(game, VkPlayDto.class);
    }
}