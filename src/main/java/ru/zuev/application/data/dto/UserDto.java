package ru.zuev.application.data.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "Users", uniqueConstraints =
		{
				@UniqueConstraint(columnNames = "ID"),
				@UniqueConstraint(columnNames = "EMAIL")
		})
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class UserDto {
	@Id
	@GeneratedValue(generator = "USER_SEQ", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "USER_SEQ", sequenceName = "USER_SEQ")
	@Column(name = "ID")
	private Long id;

	/*
	 * Имя палочки
	 */
	@Column(name = "EMAIL")
	private String email;

	/*
	 * Длина палочки
	 */
	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "CODE")
	private String code;

}
