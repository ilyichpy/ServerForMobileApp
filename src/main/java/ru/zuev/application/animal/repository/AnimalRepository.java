package ru.zuev.application.animal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.zuev.application.data.dto.AnimalDto;

import java.util.List;

public interface AnimalRepository extends JpaRepository<AnimalDto, Long> {
	List<AnimalDto> getAllByOwnerId(Long ownerId);
	AnimalDto getAnimalDtoById(Long id);
}
