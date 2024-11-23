package ru.zuev.application.animal.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.zuev.application.animal.service.AnimalService;
import ru.zuev.application.data.dto.AnimalDto;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class AnimalController {

	private final AnimalService animalService;
	@PostMapping("add_animal")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<AnimalDto> saveAnimal(@RequestBody AnimalDto animalDto) {
		animalService.saveAnimal(animalDto);
		return ResponseEntity.ok().body(new AnimalDto());
	}

	@PostMapping("animals")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<AnimalDto>> getAllAnimals(@RequestBody Long id) {
		List<AnimalDto> animalList = animalService.getAllById(id);
		return ResponseEntity.ok(animalList);
	}
	@PostMapping("get_animal_by_id")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<AnimalDto> getAnimalById(@RequestBody AnimalDto animalDto) {
		AnimalDto animal = animalService.getAnimalById(animalDto.getId());
		return ResponseEntity.ok(animal);
	}

	@PostMapping("update_animal")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<AnimalDto> updateAnimal(@RequestBody AnimalDto animalDto) {
		AnimalDto animal = animalService.update(animalDto);
		return ResponseEntity.ok(animal);
	}
}
