package ru.zuev.application.data.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "Animals", uniqueConstraints =
		{
				@UniqueConstraint(columnNames = "ID"),
				@UniqueConstraint(columnNames = "EMAIL")
		})
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class AnimalDto {
	@Id
	@GeneratedValue(generator = "ANIMAL_SEQ", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "ANIMAL_SEQ", sequenceName = "ANIMAL_SEQ")
	@Column(name = "ID")
	private Long id;
	private String name;
	private int age;
	private String type;
	private String feedingTime;
	private Long ownerId;
}
