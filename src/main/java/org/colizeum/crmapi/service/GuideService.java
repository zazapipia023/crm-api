package org.colizeum.crmapi.service;

import lombok.RequiredArgsConstructor;
import org.colizeum.crmapi.dto.GuideDto;
import org.colizeum.crmapi.exception.GuideNotFoundException;
import org.colizeum.crmapi.model.Guide;
import org.colizeum.crmapi.repository.GuideRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GuideService {

    private final GuideRepository repository;
    private final ModelMapper modelMapper;

    @Transactional
    public GuideDto create(GuideDto dto) {
        Guide guide = modelMapper.map(dto, Guide.class);
        Guide savedGuide = repository.save(guide);
        return modelMapper.map(savedGuide, GuideDto.class);
    }

    public List<GuideDto> getAllGuides() {
        return repository.findAll().stream().map(this::mapToGuideDto).collect(Collectors.toList());
    }

    @Transactional
    public void deleteGuide(String title) {
        if (repository.findByTitle(title).isEmpty()) {
            throw new GuideNotFoundException("Guide with title" + title + " not found");
        }
        repository.deleteByTitle(title);
    }

    private GuideDto mapToGuideDto(Guide guide) {
        return modelMapper.map(guide, GuideDto.class);
    }
}
