package ru.zuev.application.emailCode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.zuev.application.data.dto.UserDto;

@Repository
public interface EmailRepository extends JpaRepository<UserDto, Long> {
	public UserDto findUserDtoByEmail(String email);
}
