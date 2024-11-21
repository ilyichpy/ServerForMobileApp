package ru.zuev.application.animal.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.zuev.application.animal.repository.AnimalRepository;
import ru.zuev.application.data.dto.AnimalDto;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimalService {
	private final AnimalRepository animalRepository;

	public void saveAnimal(AnimalDto dto) {
		animalRepository.save(dto);
	}

	public List<AnimalDto> getAllById(Long id) {
		return animalRepository.getAllByOwnerId(id);
	}

	public AnimalDto getAnimalById(Long id) {
		return animalRepository.getAnimalDtoById(id);
	}

	public AnimalDto update(AnimalDto animalDto) {
		return animalRepository.save(animalDto);
	}
}
